package com.qbanxiaoli.sms.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.qbanxiaoli.common.model.vo.ResponseVO;
import com.qbanxiaoli.common.util.SendSmsUtil;
import com.qbanxiaoli.sms.dao.SmsDao;
import com.qbanxiaoli.sms.enums.SmsResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Q版小李
 * @description
 * @create 2018/7/30 1:24
 */
@Slf4j
@Service
@Transactional
public class SmsService {

    private static final String RESULT = "result";

    private final SmsDao smsDao;

    @Autowired
    public SmsService(SmsDao smsDao) {
        this.smsDao = smsDao;
    }

    public ResponseVO sendMessage(String phone) {
        //获取6位数验证码
        String code = SendSmsUtil.getRandNum(1, 999999);
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = SendSmsUtil.sendSms(phone, code);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        //返回数据
        if (sendSmsResponse != null && sendSmsResponse.getCode().equals("OK")) {
            log.info("短信验证码发送成功");
            return new ResponseVO<>(SmsResponseEnum.SUCCESS, sendSmsResponse);
        }
        log.info("短信验证码发送失败");
        return new ResponseVO<>(SmsResponseEnum.FAILURE, sendSmsResponse);
    }

}