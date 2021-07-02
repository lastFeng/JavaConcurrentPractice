package designPattern.behavior.strategy.design.event;

import designPattern.behavior.strategy.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        // 满减逻辑
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;

        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }
}
