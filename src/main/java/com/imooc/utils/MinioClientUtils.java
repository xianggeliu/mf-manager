package com.imooc.utils;

import com.imooc.pojo.Item;
import com.imooc.pojo.MinioEntity;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidArgumentException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.NoResponseException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.xmlpull.v1.XmlPullParserException;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MinioClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinioClientUtils.class);

    private static MinioClientUtils minioClientUtils;

    private MinioClient minioClient;

    private static int RETRY_NUM = 3;

    private static final String bucketPublicPolicy = "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\",\"s3:ListBucketMultipartUploads\"],\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Resource\":[\"arn:aws:s3:::test\"],\"Sid\":\"\"},{\"Action\":[\"s3:AbortMultipartUpload\",\"s3:DeleteObject\",\"s3:GetObject\",\"s3:ListMultipartUploadParts\",\"s3:PutObject\"],\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Resource\":[\"arn:aws:s3:::test/*\"],\"Sid\":\"\"}]}";

    public static MinioClientUtils getInstance() {
        if (null != minioClientUtils) {
            return minioClientUtils;
        }
        synchronized (MinioClientUtils.class) {
            if (null == minioClientUtils) {
                minioClientUtils = new MinioClientUtils();
            }
        }
        return minioClientUtils;
    }


    private MinioClientUtils() {
        init();
    }

    private void init() {
//        final Configuration configuration = initConfiguration();
        String url =  "172.16.16.21:9000";
        String username = "KXF2NUQFZ2THKMHIBUA4";
        String password = "K8R7HZ6+UGuIBZ0Kh25PvR+4COa24RoIPH23OhHK";
        String region = "cmcc";
        try {
            if (StringUtils.isNotEmpty(url) && StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
                minioClient = new MinioClient(url, username, password, false);
            }
        } catch (Exception e) {
            LOGGER.error("restClient.close occur error", e);
        }

    }

    public boolean createBucketPublic(String bucketName) {
        boolean isCreated;
        try {
//            if (minioClient.bucketExists(bucketName)) {
//                isCreated = false;
//            }
            minioClient.makeBucket("buzi");
            //minioClient.setBucketPolicy(bucketName, bucketPublicPolicy);
            isCreated = true;
        } catch (Exception e) {
            isCreated = false;
            LOGGER.error("createBucketPublic", e);
            e.printStackTrace();
        }
        return isCreated;
    }

    public String uploadJpegFile(String bucketName, String minioPath, String jpgFilePath) {
        return uploadFile(bucketName, minioPath, jpgFilePath, MediaType.IMAGE_JPEG_VALUE);
    }

    public String uploadJpegStream(String bucketName, String minioPath, InputStream inputStream) {
        return uploadStream(bucketName, minioPath, inputStream, MediaType.IMAGE_JPEG_VALUE);
    }

    public String uploadStream(String bucketName, String minioFilePath, InputStream inputStream, String mediaType) {
        LOGGER.info("uploadStream for bucketName={} minioFilePath={} inputStream.getclass={}, mediaType={}", bucketName,
                minioFilePath, inputStream.getClass(), mediaType);
        if (StringUtils.isBlank(mediaType)) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        try {
            putObjectWithRetry(bucketName, minioFilePath, inputStream, mediaType);
//            return cleanUrlByRemoveIp(minioClient.getObjectUrl(bucketName, minioFilePath));
            return minioClient.getObjectUrl(bucketName, minioFilePath);
        } catch (Exception e) {
            LOGGER.error("uploadStream occur error:", e);
            throw new RuntimeException(e);
        }
    }

    public String uploadFile(String bucketName, String minioFilePath, String localFile, String mediaType) {
        LOGGER.info("uploadFile for bucketName={} minioFilePath={} localFile={}, mediaType={}", bucketName,
                minioFilePath, localFile, mediaType);
        if (StringUtils.isBlank(mediaType)) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        try {
            putObjectWithRetry(bucketName, minioFilePath, localFile, mediaType);
//            return cleanUrlByRemoveIp(minioClient.getObjectUrl(bucketName, minioFilePath));
            return minioClient.getObjectUrl(bucketName, minioFilePath);
        } catch (Exception e) {
            LOGGER.error("uploadFile occur error:", e);
            throw new RuntimeException(e);
        }
    }
//
//    public List<MinioEntity> listFilesSwap(String bucketName, String prefix, boolean recursive) {
//        LOGGER.info("list files for bucketName={} prefix={} recursive={}", bucketName, prefix, recursive);
//        return swapResultToEntityList(minioClient.listObjects(bucketName, prefix, recursive));
//    }
//
//    public Iterable<Result<Item>> listFiles(String bucketName, String prefix, boolean recursive) {
//        LOGGER.info("list files for bucketName={} prefix={} recursive={}", bucketName, prefix, recursive);
//        return minioClient.listObjects(bucketName, prefix, recursive);
//    }
//
//
//    public List<MinioEntity> listFilesByBucketNameSwap(String bucketName) {
//        LOGGER.info("listFilesByBucketName for bucketName={}", bucketName);
//        return swapResultToEntityList(minioClient.listObjects(bucketName, null, true));
//    }
//
//    public Iterable<Result<Item>> listFilesByBucketName(String bucketName) {
//        LOGGER.info("listFilesByBucketName for bucketName={}", bucketName);
//        return minioClient.listObjects(bucketName, null, true);
//    }
//
//    public Iterable<Result<Item>> listFilesByBucketAndPrefix(String bucketName, String prefix) {
//        LOGGER.info("listFilesByBucketAndPrefix for bucketName={} and prefix={}", bucketName, prefix);
//        return minioClient.listObjects(bucketName, prefix, true);
//    }
//
//    public List<MinioEntity> listFilesByBucketAndPrefixSwap(String bucketName, String prefix) {
//        LOGGER.info("listFilesByBucketAndPrefix for bucketName={} and prefix={}", bucketName, prefix);
//        return swapResultToEntityList(minioClient.listObjects(bucketName, prefix, true));
//    }


//    private Configuration initConfiguration() {
//        ClassLoader classLoader = MinioClientUtils.class.getClassLoader();
//        if (null == classLoader) {
//            classLoader = Thread.currentThread().getContextClassLoader();
//        }
//
//        Configuration configuration = null;
//        URL resource = classLoader.getResource("minio.properties");
//        if (null == resource) {
//            LOGGER.error("can not find minio.properties");
//            throw new RuntimeException("can not find minio.properties");
//        }
//        try {
//            configuration = new PropertiesConfiguration(resource);
//        } catch (ConfigurationException e) {
//            LOGGER.error("load properties from url={} occur error", resource.toString());
//            throw new RuntimeException("load properties from url=" + resource.toString() + " occur error", e);
//        }
//        return configuration;
//    }

//    private MinioEntity swapResultToEntity(Result<Item> result) {
//        MinioEntity minioEntity = new MinioEntity();
//        try {
//            if (result.get() != null) {
//                Item item = result.get();
//                minioEntity.setObjectName(cleanUrlByRemoveIp(item.objectName()));
//                minioEntity.setDir(item.isDir());
//                minioEntity.setEtag(item.etag());
//                minioEntity.setLastModified(item.lastModified());
//                minioEntity.setSize(item.size());
//                minioEntity.setStorageClass(item.storageClass());
//            }
//        } catch (Exception e) {
//            LOGGER.error("UrlUtils error, e={}", e.getMessage());
//        }
//        return minioEntity;
//    }

//    private List<MinioEntity> swapResultToEntityList(Iterable<Result<Item>> results) {
//        List<MinioEntity> minioEntities = new ArrayList<>();
//        for (Result<Item> result : results) {
//            minioEntities.add(swapResultToEntity(result));
//        }
//        return minioEntities;
//    }

    public void putObjectWithRetry(String bucketName, String objectName, InputStream stream, String contentType) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InvalidArgumentException, NoResponseException, InvalidBucketNameException, XmlPullParserException, InternalException {
        int current = 0;
        boolean isSuccess = false;
        while (!isSuccess && current < RETRY_NUM) {
            try {
                minioClient.putObject(bucketName, objectName, stream, contentType);
                isSuccess = true;
            } catch (ErrorResponseException e) {
                LOGGER.warn("[minio] putObject stream, ErrorResponseException occur for time =" + current, e);
                current++;
            } catch (InternalException e) {
                e.printStackTrace();
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        if (current == RETRY_NUM) {
            LOGGER.error("[minio] putObject, backetName={}, objectName={}, failed finally!");
        }
    }

    public void putObjectWithRetry(String bucketName, String objectName, String fileName, String contentType) throws InvalidBucketNameException, NoSuchAlgorithmException, InsufficientDataException, IOException, InvalidKeyException, NoResponseException, XmlPullParserException, ErrorResponseException, InternalException, InvalidArgumentException, InsufficientDataException {
        int current = 0;
        boolean isSuccess = false;
        while (!isSuccess && current < RETRY_NUM) {
            try {
                minioClient.putObject(bucketName, objectName, fileName, contentType);
                isSuccess = true;
            } catch (ErrorResponseException e) {
                current++;
                LOGGER.debug("[minio] putObject file, ErrorResponseException occur!");
            }
        }
        if (current == RETRY_NUM) {
            LOGGER.error("[minio] putObject, backetName={}, objectName={}, failed finally!");
        }
    }

    public static void main(String[] args) {
        MinioClientUtils.getInstance().createBucketPublic("cmcc");
    }

}
