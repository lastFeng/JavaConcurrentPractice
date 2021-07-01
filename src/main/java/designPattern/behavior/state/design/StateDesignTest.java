package designPattern.behavior.state.design;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.state.base.ActivityService;
import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;
import designPattern.util.Logger;

public class StateDesignTest {

    private static Logger logger = new Logger();

    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Close);
        StateHandler handler = new StateHandler();
        Result open = handler.open(activityId, Status.Close);
        logger.info("结果（关闭-》开启）： {0}", JSON.toJSONString(open));

        logger.info("结果（关闭-》编辑）：{0}", JSON.toJSONString(handler.arraignment(activityId, Status.Close)));
    }
}
