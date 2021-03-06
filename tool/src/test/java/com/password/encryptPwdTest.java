package com.password;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qbanxiaoli
 * @description
 * @create 2018/12/6 12:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class encryptPwdTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        // d9hzbalFHO+vBhrMExlH5A==
        String result = stringEncryptor.encrypt("12345678");
        log.info(result);
    }

}
