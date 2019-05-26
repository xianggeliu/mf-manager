package com.imf.service.impl;

import com.imf.mapper.MfECompanyMapper;
import com.imf.mapper.MfExpressMapper;
import com.imf.pojo.KdEntity;
import com.imf.pojo.MFJSONResult;
import com.imf.pojo.MfECompany;
import com.imf.pojo.MfExpress;
import com.imf.pojo.Shippers;
import com.imf.service.ExpressService;
import com.imf.utils.JsonUtils;
import com.imf.utils.KdAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JiXiang on 2019/5/25 13:29
 *
 * @author : 祥哥
 * QQ :　２５２６３２３３０
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private KdAPI kdAPI ;

    @Autowired
    private MfExpressMapper meMapper;

    @Autowired
    private MfECompanyMapper mecMapper;

    @Override
    @Transactional
    public MFJSONResult insertExpressInfoNotCompany(String expressNum) throws Exception {
        //获取快递返回的信息
        String kdJson = kdAPI.getOrderTracesByJson(expressNum);
        KdEntity kdEntity = JsonUtils.jsonToPojo(kdJson, KdEntity.class);
        if (kdEntity == null ||kdEntity.getShippers() == null  ||kdEntity.getShippers().size() != 1){
            Map<String , String> map = new HashMap<>();
            map.put("message" , "获取的公司不存在或者是多个！");
            map.put("state","204");
            return MFJSONResult.errorMap(map);
        }
        //添加信息
        MfExpress mfExpress = new MfExpress();
        Shippers shippers = kdEntity.getShippers().get(0);
        mfExpress.seteCompany(shippers.getShipperName());
        mfExpress.setExpressNumber(expressNum);
        int companyId = getCompanyId(shippers.getShipperName(), shippers.getShipperCode());
        mfExpress.seteCompanyCode(companyId);
        mfExpress.setEnteringTime(System.currentTimeMillis());
        mfExpress.seteState(1);
        int insert = meMapper.insert(mfExpress);
        if (insert == 1){
            return MFJSONResult.ok();
        }
        return MFJSONResult.errorMsg("添加快递信息异常！");
    }


    private int getCompanyId(String companyName , String companyCode){
        MfECompany mc =  mecMapper.selectByCompanyName(companyName);
        if (mc != null ){
            return mc.getId();
        }
        MfECompany mec = new MfECompany();
        mec.seteCompanyName(companyName);
        mec.seteCompanyCode(companyCode);
        int i = mecMapper.insertSelective(mec);
        return i;
    }

    @Override
    public MFJSONResult insertExpressInfo(String expressNum, String companyCode) {
        //添加信息
        MfECompany mfECompany = mecMapper.selectByPrimaryKey(Integer.parseInt(companyCode));
        MfExpress mfExpress = new MfExpress();
        mfExpress.seteCompany(mfECompany.geteCompanyName());
        mfExpress.setExpressNumber(expressNum);
        mfExpress.seteCompanyCode(mfECompany.getId());
        mfExpress.setEnteringTime(System.currentTimeMillis());
        mfExpress.seteState(1);
        int insert = meMapper.insert(mfExpress);
        if (insert == 1){
            return MFJSONResult.ok();
        }
        return MFJSONResult.errorMsg("添加快递信息失败，请联系祥哥！");
    }

    @Override
    public MFJSONResult takesExpress(String expressNum) {
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress == null){
            return MFJSONResult.errorMsg("该快递不存在，是否录入？");
        }
        mfExpress.seteState(0);
        mfExpress.setGetTime(System.currentTimeMillis());
        int state = meMapper.updateByPrimaryKey(mfExpress);
        if (state ==1 ){
            return MFJSONResult.ok();
        }
        return MFJSONResult.errorMsg("更新快递状态失败，请联系祥哥！");
    }

    @Override
    public MFJSONResult getExpress(String expressNum) {
        MfExpress mfExpress = meMapper.selectByExpressNum(expressNum);
        if (mfExpress != null){
            return MFJSONResult.ok(mfExpress);
        }
        return MFJSONResult.errorMsg("快递不存在,请确认该快递单号是否正确!");
    }
}
