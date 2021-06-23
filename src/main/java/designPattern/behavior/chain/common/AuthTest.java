package designPattern.behavior.chain.common;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.chain.base.AuthService;
import designPattern.util.Logger;

import java.text.ParseException;
import java.util.Date;

public class AuthTest {
    public static void main(String[] args) throws ParseException {
        AuthController controller = new AuthController();
        Logger logger = new Logger();

        logger.info("测试结果：{0}", JSON.toJSONString(controller.doAuth("1", "1", new Date())));

        AuthService.auth("1000013", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(controller.doAuth("1", "1", new Date())));

        AuthService.auth("1000012", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(controller.doAuth("1", "1", new Date())));

        AuthService.auth("1000011", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(controller.doAuth("1", "1", new Date())));
    }
}
