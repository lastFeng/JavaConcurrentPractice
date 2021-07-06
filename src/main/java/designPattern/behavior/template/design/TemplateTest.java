package designPattern.behavior.template.design;

import designPattern.behavior.template.design.group.JDNetMall;
import designPattern.util.Logger;

public class TemplateTest {

    private static Logger logger = new Logger();

    public static void main(String[] args) {
        NetMall netMall = new JDNetMall("100001", "***********");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{0}", base64);
    }
}
