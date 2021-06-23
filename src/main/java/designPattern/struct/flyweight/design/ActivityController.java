package designPattern.struct.flyweight.design;

import designPattern.struct.flyweight.base.Activity;
import designPattern.struct.flyweight.base.Stock;
import designPattern.struct.flyweight.design.util.RedisUtils;

public class ActivityController {
    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);

        Stock stock = new Stock(1000, redisUtils.getStockedUsed());
        activity.setStock(stock);
        return activity;
    }

    public void shutdown() {
        redisUtils.shutDown();
    }
}
