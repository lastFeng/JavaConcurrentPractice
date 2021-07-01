package designPattern.behavior.state.common;

import designPattern.behavior.state.base.ActivityService;
import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;

public class ActivityExecStatusController {
    /**
     * 活动状态变更：
     *  1. 编辑 --》 审核、关闭
     *  2. 通过 --》 拒绝、关闭、活动中
     *  3. 拒绝 --》 撤销、关闭
     *  4. 活动中--》 关闭
     *  5. 关闭 --》 开启
     *  6. 开启 --》 关闭
     */
    public Result execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        // 编辑 --》 审核、关闭
        if (Status.Editing.equals(beforeStatus)) {
            if (Status.Check.equals(afterStatus) || Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }
        // 通过 --》 拒绝、关闭、活动中
        if (Status.Pass.equals(beforeStatus)) {
            if (Status.Refuse.equals(afterStatus) || Status.Close.equals(afterStatus) || Status.Doing.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }

        // 拒绝 --》 撤销、关闭
        if (Status.Refuse.equals(beforeStatus)) {
            if (Status.Refuse.equals(afterStatus) || Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }

        // 活动中--》 关闭
        if (Status.Doing.equals(beforeStatus)) {
            if (Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }

        // 关闭 --》 开启
        if (Status.Close.equals(beforeStatus)) {
            if (Status.Open.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }

        // 开启 --》 关闭
        if (Status.Open.equals(beforeStatus)) {
            if (Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "变更状态成功");
            } else {
                return new Result("0001", "变更状态失败");
            }
        }
        return new Result("0001", "非可处理状态");
    }
}
