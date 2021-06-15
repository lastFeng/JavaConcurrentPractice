package designPattern.create.factory.design.store.impl;

import designPattern.create.factory.base.goods.DeliverReq;
import designPattern.create.factory.base.goods.GoodsService;
import designPattern.create.factory.design.store.ICommodity;
import designPattern.util.Logger;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {
    private GoodsService goodsService = new GoodsService();
    private Logger logger = new Logger();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[优惠券] => uId：{0} commodityId：{1} bizId：{2} extMap：{3}", uId, commodityId, bizId, extMap.toString());
        logger.info("测试结果[优惠券]：{0}", isSuccess);

        if (!isSuccess) throw new RuntimeException("实物商品发放失败");
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
