package designPattern.struct.flyweight.design;

import com.alibaba.fastjson.JSON;
import designPattern.struct.flyweight.base.Activity;
import designPattern.util.Logger;

public class FlyweightTest {
    private static Logger logger = new Logger();
    public static void main(String[] args) throws InterruptedException {
        ActivityController activityController = new ActivityController();
        for (int i = 0; i < 10; i++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            logger.info("测试结果： {0} {1}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
        activityController.shutdown();
    }
}
