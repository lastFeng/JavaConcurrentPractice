package designPattern.behavior.strategy.design;

import designPattern.behavior.strategy.design.event.ZJCouponDiscount;
import designPattern.util.Logger;

import java.math.BigDecimal;

public class StrategyDesignTest {
    private static Logger logger = new Logger();
    public static void main(String[] args) {
        // 直减 100 - 10
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal bigDecimal = context.discountAmount(10D, new BigDecimal(100));
        logger.info("直减结果：{0}", bigDecimal.doubleValue());
    }
}
