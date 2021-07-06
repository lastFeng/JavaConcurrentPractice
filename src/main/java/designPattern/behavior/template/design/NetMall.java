package designPattern.behavior.template.design;

import designPattern.util.Logger;

import java.util.Map;

public abstract class NetMall {
    protected Logger logger = new Logger();

    String uId;     // 用户Id
    String uPwd;    // 用户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * 生成商品推广海报
     * @param skuUrl
     * @return
     */
    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null;               // 验证登录

        Map<String, String> reptile = reptile(skuUrl);   // 爬虫商品
        return createBase64(reptile);                    // 组装海报
    }
    
    protected abstract Boolean login(String uId, String uPwd);

    protected abstract Map<String, String> reptile(String skuUrl);

    protected abstract String createBase64(Map<String, String> goodsInfo);
}
