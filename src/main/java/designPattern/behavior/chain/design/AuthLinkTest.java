package designPattern.behavior.chain.design;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.chain.base.AuthService;
import designPattern.behavior.chain.design.impl.LevelOneAuthLink;
import designPattern.behavior.chain.design.impl.LevelThreeAuthLink;
import designPattern.behavior.chain.design.impl.LevelTwoAuthLink;
import designPattern.util.Logger;

import java.text.ParseException;
import java.util.Date;

public class AuthLinkTest {
    public static void main(String[] args) throws ParseException {

        Logger logger = new Logger();

        AuthLink authLink = new LevelThreeAuthLink("1000013", "老王")
                .appendNext(new LevelTwoAuthLink("1000012", "老张")
                        .appendNext(new LevelOneAuthLink("1000011", "老段")));

        logger.info("测试结果： {0}", JSON.toJSONString(authLink.doAuth("1", "1", new Date())));

        AuthService.auth("1000013", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(authLink.doAuth("1", "1", new Date())));

        AuthService.auth("1000012", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(authLink.doAuth("1", "1", new Date())));

        AuthService.auth("1000011", "1");
        logger.info("测试结果：{0}", JSON.toJSONString(authLink.doAuth("1", "1", new Date())));

    }
}
