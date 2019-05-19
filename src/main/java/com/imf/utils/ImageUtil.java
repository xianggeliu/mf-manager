package com.imf.utils;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * <p>Title: ImageUtil </p>
 * <p>Description: </p>
 * <p>Email: icerainsoft@hotmail.com </p>
 *
 * @author Ares
 * @date 2014年10月28日 上午10:24:26
 */
public class ImageUtil {

    private Logger log = LoggerFactory.getLogger(getClass());

    private static String DEFAULT_THUMB_PREVFIX = "thumb_";
    private static String DEFAULT_CUT_PREVFIX = "cut_";
    private static Boolean DEFAULT_FORCE = false;


    /**
     * <p>Title: cutImage</p>
     * <p>Description:  根据原图与裁切size截取局部图片</p>
     *
     * @param srcImg 源图片
     * @param output 图片输出流
     * @param rect   需要截取部分的坐标和大小
     */
    public void cutImage(File srcImg, OutputStream output, Rectangle rect) {
        if (srcImg.exists()) {
            FileInputStream fis = null;
            ImageInputStream iis = null;
            try {
                fis = new FileInputStream(srcImg);
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
                String suffix = null;
                // 获取图片后缀
                if (srcImg.getName().indexOf(".") > -1) {
                    suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀全部小写，然后判断后缀是否合法
                if (suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase() + ",") < 0) {
                    log.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                    return;
                }
                // 将FileInputStream 转换为ImageInputStream
                iis = ImageIO.createImageInputStream(fis);
                // 根据图片类型获取该种类型的ImageReader
                ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
                reader.setInput(iis, true);
                ImageReadParam param = reader.getDefaultReadParam();
                param.setSourceRegion(rect);
                BufferedImage bi = reader.read(0, param);
                ImageIO.write(bi, suffix, output);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) fis.close();
                    if (iis != null) iis.close();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            log.warn("the src image is not exist.");
        }
    }

    public void cutImage(File srcImg, OutputStream output, int x, int y, int width, int height) {
        cutImage(srcImg, output, new Rectangle(x, y, width, height));
    }

    public String cutImage(File srcImg, String destImgPath, Rectangle rect) throws FileNotFoundException {
        File destImg = new File(destImgPath);
        cutImage(srcImg, new FileOutputStream(destImgPath), rect);
        return "";
    }

    public void cutImage(File srcImg, String destImg, int x, int y, int width, int height) throws FileNotFoundException {
        cutImage(srcImg, destImg, new Rectangle(x, y, width, height));
    }

    public String cutImage(String srcImg, String destImg, int x, int y, int width, int height) throws IOException {
//        BufferedImage bi = ImageIO.read(new File(srcImg));
//        int srcWidth = bi.getWidth(); // 源图宽度
//        int srcHeight = bi.getHeight(); // 源图高度
        return cutImage(new File(srcImg), destImg, new Rectangle(x, y, width, height));

    }

    /**
     * <p>Title: thumbnailImage</p>
     * <p>Description: 根据图片路径生成缩略图 </p>
     *
     * @param w     缩略图宽
     * @param h     缩略图高
     * @param force 是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     */
    public int thumbnailImage(File srcImg, OutputStream output, int w, int h, String fileName, boolean force, String lastName) throws IOException {
        if (srcImg.exists()) {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
                String suffix = null;
                // 获取图片后缀
                if (srcImg.getName().indexOf(".") > -1) {
                    suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀全部小写，然后判断后缀是否合法
//                if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()+",") < 0){
//                    log.error("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
//                    return ;
//                }
                log.debug("target image's size, width:{}, height:{}.", w, h);
                Image img = ImageIO.read(srcImg);
                // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                File newFile = null;
                if (img == null) {
                    newFile = new File(ConvertTif(fileName));
                    img = ImageIO.read(newFile);
                    if (img == null) {
                        log.debug("imageUtil 图片转换处理不成功~！");
                        return 0;
                    }
                }
                force = false;

                if (!force) {
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if ((width * 1.0) / w < (height * 1.0) / h) {
                        if (width > w) {
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w / (width * 1.0)));
                            log.debug("change image's height, width:{}, height:{}.", w, h);
                        }
                    } else {
                        if (height > h) {
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h / (height * 1.0)));
                            log.debug("change image's width, width:{}, height:{}.", w, h);
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                // 将图片保存在原目录并加上前缀
                ImageIO.write(bi, lastName.replace(".", ""), output);
                if (newFile != null) newFile.delete();
                output.close();
                return 1;
        } else {
            log.warn("the src image is not exist.");
            return 0;
        }
    }

    public int thumbnailImage(File srcImg, int w, int h, String fileName, boolean force, String lastName) throws Exception {
        String p = srcImg.getAbsolutePath();
            if (!srcImg.isDirectory()) p = srcImg.getParent();
            if (!p.endsWith(File.separator)) p = p + File.separator;
            return thumbnailImage(srcImg, new FileOutputStream(p + 2 + lastName), w, h, fileName, force, lastName);
    }

    //处理特殊文件
    public String ConvertTif(String filename) {
        //生成不重复的文件名
        String lastName = filename.substring(filename.lastIndexOf(".")); // 获取文件的后缀
        String alternateName = filename.replace(lastName, "t" + lastName);
        try {
            RenderedOp src = JAI.create("fileload", filename);
            OutputStream os = new FileOutputStream(alternateName);
            com.sun.media.jai.codec.JPEGEncodeParam param2 = new com.sun.media.jai.codec.JPEGEncodeParam();
            ImageEncoder enc2 = ImageCodec.createImageEncoder("JPEG", os, param2);
            enc2.encode(src);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alternateName;
    }


    public static void main(String[] args) throws IOException {
//        iul.thumbnailImage(f, new java.io.FileOutputStream(z_file), 300, 200, z_name, false);
//        new ImageUtil().thumbnailImage(new File("D:\\Totls\\test/94610364.png"), new FileOutputStream("D:\\Totls\\test/11.png"), 300, 200, "D:\\Totls\\test/94610364.png", false, ".png");
//        new ImageUtil().thumbnailImage(new File("D:\\Totls\\test/11.gif"), 300, 200, "D:\\Totls\\test/11.gif", false);
//        new ImageUtil().thumbnailImage(new File("D:\\Totls\\test/t018bf88cc1862a53ea.jpg"),new java.io.FileOutputStream(new File("D:\\Totls\\test/2.jpg")), 300, 200,"2.jpg",false);

//        new ImageUtil().cutImage("D:\\Totls\\test/1.jpg", "D:\\Totls\\test/2.jpg", 10, 10, 293, 200);
    }

}