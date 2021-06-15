package designPattern.create.factory.design.store.impl;

import designPattern.create.factory.base.coupon.CouponResult;
import designPattern.create.factory.base.coupon.CouponService;
import designPattern.create.factory.design.store.ICommodity;
import designPattern.util.Logger;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    private CouponService couponService = new CouponService();
    private Logger logger = new Logger();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, extMap.toString());
        logger.info("测试结果[优惠券]：{}", couponResult.toString());
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
