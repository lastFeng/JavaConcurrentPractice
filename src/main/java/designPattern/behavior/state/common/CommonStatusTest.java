package designPattern.behavior.state.common;

import com.alibaba.fastjson.JSON;
import designPattern.behavior.state.base.ActivityService;
import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;
import designPattern.util.Logger;

public class CommonStatusTest {
    private static Logger logger = new Logger();
    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        ActivityExecStatusController controller = new ActivityExecStatusController();
        Result result = controller.execStatus(activityId, Status.Editing, Status.Close);
        logger.info("结果（编辑 --》 拒绝）：{0}", JSON.toJSONString(result));
    }
}
