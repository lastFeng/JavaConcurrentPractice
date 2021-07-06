package designPattern.behavior.template.design.group;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.template.design.HttpClient;
import designPattern.behavior.template.design.NetMall;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDNetMall extends NetMall {

    public JDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        logger.info("模拟JD登录：uId-{0}， uPwd-{1}", uId, uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<>();

        if (m9.find()) {
            map.put("name", m9.group());
        }

        map.put("price", "5999.00");
        logger.info("模拟JD商品爬虫解析：{0} | {1} 元 {2}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟生成JD商品base64海报");

        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes(StandardCharsets.UTF_8));
    }
}
