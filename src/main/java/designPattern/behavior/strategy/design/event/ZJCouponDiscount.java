package designPattern.behavior.strategy.design.event;

import designPattern.behavior.strategy.design.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }
}
