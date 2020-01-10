package com.imf.service.impl;

import com.imf.constants.MFConstant;
import com.imf.mapper.MfECompanyMapper;
import com.imf.mapper.MfEMessageMapper;
import com.imf.mapper.MfExpressDayTotalMapper;
import com.imf.mapper.MfExpressMapper;
import com.imf.mapper.MfExpressUserMapper;
import com.imf.mapper.MfMessageInfoMapper;
import com.imf.pojo.KdEntity;
import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfECompany;
import com.imf.pojo.MfECompanyExample;
import com.imf.pojo.MfEMessage;
import com.imf.pojo.MfExpress;
import com.imf.pojo.MfExpressDayTotal;
import com.imf.pojo.MfExpressExample;
import com.imf.pojo.MfExpressUser;
import com.imf.pojo.MfMessageInfo;
import com.imf.pojo.MfMsg;
import com.imf.pojo.Shippers;
import com.imf.service.ExpressService;
import com.imf.utils.CommonUtil;
import com.imf.utils.JsonUtils;
import com.imf.utils.KdAPI;
import com.imf.utils.RedisOperator;
import com.imf.utils.SmsSample;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JiXiang on 2019/5/25 13:29
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Service
public class ExpressServiceImpl implements ExpressService {
    private static final Logger logger = Logger.getLogger(ExpressServiceImpl.class);

    @Autowired
    private MfMsg mfMsg;

    @Autowired
    private KdAPI kdAPI;

    @Autowired
    private MfExpressMapper meMapper;

    @Autowired
    private MfECompanyMapper mecMapper;

    @Autowired
    private RedisOperator redis;

    @Autowired
    private MfExpressDayTotalMapper medtMapper;

    @Autowired
    private MfEMessageMapper messageMapper;

    @Autowired
    private MfMessageInfoMapper messageInfoMapper;

    @Autowired
    private MfExpressUserMapper mfExpressUserMapper;

    @Override
    @Transactional
    public MFJSONResult insertExpressInfoNotCompany(String expressNum) throws Exception {
        //获取快递返回的信息
        String kdJson = kdAPI.getOrderTracesByJson(expressNum);
        KdEntity kdEntity = JsonUtils.jsonToPojo(kdJson, KdEntity.class);
        if (kdEntity == null || kdEntity.getShippers() == null || kdEntity.getShippers().size() != 1) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "获取的公司不存在或者是多个！");
            map.put("state", "204");
            return MFJSONResult.errorMap(map);
        }
        //添加信息
        MfExpress mfExpress = new MfExpress();
        Shippers shippers = kdEntity.getShippers().get(0);
        mfExpress.seteCompany(shippers.getShipperName());
        mfExpress.setExpressNumber(expressNum);
        int companyId = getCompanyId(shippers.getShipperName(), shippers.getShipperCode());
        mfExpress.seteCompanyCode(companyId);
        mfExpress.setEnteringTime(new Date());
        if (StringUtils.isEmpty(redis.get("MF:express:expressCount"))) {
            redis.set("MF:express:expressCount", "1");
        }
        String redisKey = redis.get("MF:express:expressCount");
        mfExpress.seteMark(Integer.parseInt(redisKey));
        mfExpress.seteState(1);
        int insertState = meMapper.insert(mfExpress);
        if (insertState == 1) {
            redis.incr("MF:express:expressCount", 1);
            return MFJSONResult.ok();
        }
        return MFJSONResult.errorMsg("添加快递信息异常！");
    }


    private int getCompanyId(String companyName, String companyCode) {
        MfECompany mc = mecMapper.selectByCompanyName(companyName);
        if (mc != null) {
            return mc.getId();
        }
        MfECompany mec = new MfECompany();
        mec.seteCompanyName(companyName);
        mec.seteCompanyCode(companyCode);
        int i = mecMapper.insertSelective(mec);
        return i;
    }

    @Override
    @Transactional
    public MFJSONResult insertExpressInfo(String expressNum, String companyCode, String phone, String name, int state) throws Exception {
        //添加信息

//        Integer status = saveExpressInfo(expressNum, companyCode, phone, name, 1);
//        if (status == 0){
////            return MFJSONResult.errorMsg("该快递单号已经存在，不能重复录入！");
////        }else if (status == -1){
////            return MFJSONResult.errorMsg("添加快递信息失败，请联系祥哥！");
////        }
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress != null) {
            return MFJSONResult.errorMsg("该快递单号已经存在，不能重复录入！");
        } else {
            mfExpress = new MfExpress();
        }
        String expressCount = redis.get(MFConstant.REDIS_EXPRESS_COUNT);
        MfECompany mfECompany = mecMapper.selectByPrimaryKey(Integer.parseInt(companyCode));
        mfExpress.seteCompany(mfECompany.geteCompanyName());
        mfExpress.setExpressNumber(expressNum);
        mfExpress.seteCompanyCode(mfECompany.getId());
        mfExpress.setePhone(phone);
        mfExpress.seteName(name);
        mfExpress.setEnteringTime(new Date());
        if(state == 0){
            mfExpress.setGetTime(new Date());
            mfExpress.seteState(0);
        }else {
            if (StringUtils.isEmpty(redis.get(MFConstant.REDIS_EXPRESS_COUNT))) {
                redis.set(MFConstant.REDIS_EXPRESS_COUNT, "1");
            }
            mfExpress.seteMark(Integer.parseInt(expressCount));
            mfExpress.seteState(1);
        }

        int insert = meMapper.insert(mfExpress);
        if (insert == 1) {
            //处理用户的手机号
            try {
                this.dealUserInfo(phone, name);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("处理用户信息异常~！");
            }
            //调用短信接口发送短信
            if (state != 0) {
                return sendMessage(phone ,expressCount , name);
            }else{
                return MFJSONResult.ok("快递录入成功!");
            }
        }
        return MFJSONResult.errorMsg("添加快递信息失败，请联系祥哥！");
    }

    public MFJSONResult sendMessage(String phone, String expressCount , String userName) throws Exception {
        //获取数据库 短信模板信息，替换指定字段
        MfEMessage message = this.getMessage();
        String content = message.getContent();
        content = content.replace("date" ,CommonUtil.formatDate("MM月dd日"));
        content =  content.replace("code" , expressCount);
        //封装短信记录，数据库存储发送短信记录
        MfMessageInfo mmsi = new MfMessageInfo();
        mmsi.setMessage(content);
        mmsi.setMobile(phone);
        mmsi.setSendTime(new Date());
        mmsi.setUserName(userName);
        String sendState = SmsSample.sendMsg(phone, content , mfMsg);
        redis.incr(MFConstant.REDIS_EXPRESS_COUNT, 1);
        if ("0".equals(sendState)) {
            mmsi.setSendState(1);
            messageInfoMapper.insert(mmsi);
            return MFJSONResult.ok("快递录入成功，取件号是：" + expressCount);
        } else {
            mmsi.setSendState(0);
            messageInfoMapper.insert(mmsi);
            return MFJSONResult.ok("发送短信异常 ： " + msgJudge(sendState) + ";请手动发送短信！取件号是：" + expressCount);
        }
    }


    /**
     * 保存处理用户信息
     *
     * @param phone
     * @param name
     */
    private void dealUserInfo(String phone, String name) {
        MfExpressUser meu = this.getMFExpressUser(phone);
        if (meu != null) {
            if (!meu.getName().equals(name)) {
                meu.setName(name);
                mfExpressUserMapper.updateByPrimaryKey(meu);
            }
        } else {
            meu = new MfExpressUser();
            meu.setName(name);
            meu.setMobile(phone);
            mfExpressUserMapper.insert(meu);
        }
    }

    /**
     * 通过手机号获取用户信息
     *
     * @param phone
     * @return
     */
    private MfExpressUser getMFExpressUser(String phone) {
        return mfExpressUserMapper.selectByMobile(phone);
    }

    private String msgJudge(String state) {
        int anInt = Integer.parseInt(state);
        String msg;
        switch (anInt) {
            case 30:
                msg = "错误密码！";
                break;
            case 40:
                msg = "账号不存在！";

                break;
            case 41:
                msg = "余额不足！";

                break;
            case 43:
                msg = "IP地址限制！";

                break;
            case 50:
                msg = "内容含有敏感词！";

                break;
            case 51:
                msg = "手机号码不正确！";
                break;
            default:
                msg = "发送短信异常！";
                break;
        }
        return msg;

    }


    @Override
    public MFJSONResult takesExpress(String expressNum) {
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress == null) {
            return MFJSONResult.errorMsg("该快递不存在，是否录入？");
        }
        if (mfExpress.geteState() == 0) {
            return MFJSONResult.errorTokenMsg("快递已经出库，不能重新出库！");
        }
        mfExpress.seteState(0);
        mfExpress.setGetTime(new Date());
        int state = meMapper.updateByPrimaryKey(mfExpress);
        if (state == 1) {
            if (StringUtils.isEmpty(redis.get(MFConstant.REDIS_EXPRESS_COUNT))) {
                redis.set(MFConstant.REDIS_EXPRESS_COUNT, "1");
            }
            redis.incr(MFConstant.REDIS_EXPRESS_COUNT, 1);
            return MFJSONResult.ok();
        }
        return MFJSONResult.errorMsg("更新快递状态失败，请联系祥哥！");
    }

    @Override
    public MFJSONResult getExpress(String expressNum) {
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress != null) {
            return MFJSONResult.ok(mfExpress);
        }
        return MFJSONResult.errorMsg("快递不存在,请确认该快递单号是否正确!");
    }

    /**
     * 获取快递公司信息
     *
     * @param expressNum
     * @return
     */
    @Override
    public MFJSONResult getExpressInfo(String expressNum) throws Exception {
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress != null) {
            return MFJSONResult.errorMsg("该快递单号已经存在，不能重复录入！");
        }
        String kdJson = kdAPI.getOrderTracesByJson(expressNum);
        KdEntity kdEntity = JsonUtils.jsonToPojo(kdJson, KdEntity.class);
        if (kdEntity == null || kdEntity.getShippers() == null) {
            return MFJSONResult.ok();
        }
        Shippers shippers = kdEntity.getShippers().get(0);
        int companyId = getCompanyId(shippers.getShipperName(), shippers.getShipperCode());
        shippers.setShipperCode(companyId + "");
        return MFJSONResult.ok(shippers);
    }

    /**
     * 保存出入库总数
     *
     * @param state 1 是保存入库   0 是保存出库
     * @return
     * @throws Exception
     */
    @Override
    public MFJSONResult saveExpressInTotal(int state) throws Exception {
        int day = Integer.parseInt(CommonUtil.formatDate("yyyyMMdd"));
        MfExpressDayTotal mfExpressDayTotal = medtMapper.selectByPrimaryKey(day);
        if (state == 1) {
            String inCount = redis.get(MFConstant.REDIS_EXPRESS_COUNT);
            int inTotal = Integer.parseInt(inCount) - 1;
            if (mfExpressDayTotal == null) {
                mfExpressDayTotal = new MfExpressDayTotal();
                mfExpressDayTotal.setId(day);
                mfExpressDayTotal.setIntoTotal(inTotal);
                medtMapper.insert(mfExpressDayTotal);
            } else {
                if (mfExpressDayTotal.getIntoTotal() != null) {
                    return MFJSONResult.ok("当天入库已完成，不能重复入库!");
                }
                mfExpressDayTotal.setIntoTotal(inTotal);
                medtMapper.updateByPrimaryKey(mfExpressDayTotal);
            }
            redis.set(MFConstant.REDIS_EXPRESS_COUNT, "1");
            return MFJSONResult.ok("入库完成：" + day + "一共入库了：" + inTotal + "件快递！");
        } else if (state == 0) {
            String outCount = redis.get(MFConstant.REDIS_EXPRESS_COUNT);
            int outTotal = Integer.parseInt(outCount) - 1;

            if (mfExpressDayTotal == null) {
                mfExpressDayTotal = new MfExpressDayTotal();
                mfExpressDayTotal.setId(day);
                mfExpressDayTotal.setOutTotal(outTotal);
                medtMapper.insert(mfExpressDayTotal);
            } else {
                if (mfExpressDayTotal.getOutTotal() != null) {
                    return MFJSONResult.ok("当天出库已完成，不能重复出库!");
                }
                mfExpressDayTotal.setOutTotal(outTotal);
                medtMapper.updateByPrimaryKey(mfExpressDayTotal);
            }

            redis.set(MFConstant.REDIS_EXPRESS_COUNT, "1");
            return MFJSONResult.ok("出库完成：" + day + "一共出库了：" + outTotal + "件快递！");
        }
        return MFJSONResult.errorMap("您的操作不存在，请联系管理员！");
    }

    @Override
    public List<MfExpress> getExpressAll(String mobile, String number, String eCompany, Integer eState, String tState) {
        MfExpressExample mfExpressExample = new MfExpressExample();
        MfExpressExample.Criteria criteria = mfExpressExample.createCriteria();

        if (StringUtils.isNotEmpty(number)) {
            criteria.andExpressNumberEqualTo(number);
            eState = null;
        }

        if (StringUtils.isNotEmpty(mobile)) {
            criteria.andEPhoneEqualTo(mobile);
            if (eState != 0){
                eState = null;
            }
        }
        if (StringUtils.isNotEmpty(eCompany)) {
            criteria.andECompanyCodeEqualTo(eCompany);
        }
        if (eState != null) {
            criteria.andEStateEqualTo(eState);
        }
        mfExpressExample.setOrderByClause("get_time " + tState);
        List<MfExpress> mfExpresses = meMapper.selectByExample(mfExpressExample);
        return mfExpresses;
    }

    /**
     * 保存短信样板
     *
     * @param content
     * @return
     */
    @Override
    public Object saveMessage(String content) {
        MfEMessage mfEMessage = this.getMessage();
        if (mfEMessage != null) {
            mfEMessage.setContent(content);
            mfEMessage.setUpdateTime(new Date());
            messageMapper.updateByPrimaryKey(mfEMessage);
        } else {
            mfEMessage = new MfEMessage();
            mfEMessage.setCreateTime(new Date());
            mfEMessage.setContent(content);
            messageMapper.insert(mfEMessage);
        }
        return MFJSONResult.ok();
    }

    /**
     * 获取短信模板信息
     *
     * @return
     */
    @Override
    public MfEMessage getMessage() {
        String content = redis.get(MFConstant.REDIS_MESSAGE_KEY);
        if (StringUtils.isNotEmpty(content)) {
            return JsonUtils.jsonToPojo(content, MfEMessage.class);
        }
        MfEMessage mfEMessage = messageMapper.selectByPrimaryKey(1);
        if (mfEMessage != null) {
            redis.set(MFConstant.REDIS_MESSAGE_KEY, JsonUtils.objectToJson(mfEMessage));
            redis.expire(MFConstant.REDIS_MESSAGE_KEY, 1200);
        }
        return mfEMessage;
    }

    /**
     * 获取所有的快递公司信息
     *
     * @return
     */
    @Override
    public MFJSONResult loadCompanyName() {
        MfECompanyExample mec = new MfECompanyExample();
        List<MfECompany> mfECompanies = mecMapper.selectByExample(mec);
        return MFJSONResult.ok(mfECompanies);
    }


    /**
     * 通过手机号 获取用户信息
     *
     * @param mobile
     * @return
     */
    @Override
    public MFJSONResult loadUser(String mobile) {
        MfExpressUser mfExpressUser = this.getMFExpressUser(mobile);
        if (mfExpressUser != null) {
            return MFJSONResult.ok(mfExpressUser);
        }
        return MFJSONResult.errorMsg("获取用户信息为空！");
    }
}


