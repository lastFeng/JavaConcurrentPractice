package designPattern.create.factory.design.store.impl;

import designPattern.create.factory.base.card.IQiYiCardService;
import designPattern.create.factory.design.store.ICommodity;
import designPattern.util.Logger;

import java.util.Map;

public class CardCommodityService implements ICommodity {
    // 模拟注入
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();
    private Logger logger = new Logger();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{0} commodityId：{1} bizId：{2} extMap：{3}", uId, commodityId == null ? "" : commodityId, bizId == null ? "" : bizId, extMap == null ? "" : extMap.toString());
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
