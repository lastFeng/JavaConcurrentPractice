package designPattern.struct.flyweight.common;

import designPattern.struct.flyweight.base.Activity;
import designPattern.struct.flyweight.base.Stock;

import java.util.Date;

public class ActivityController {
    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("Test");
        activity.setDesc("Test");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }
}
