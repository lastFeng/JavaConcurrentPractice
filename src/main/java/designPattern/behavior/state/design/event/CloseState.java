package designPattern.behavior.state.design.event;

import designPattern.behavior.state.base.ActivityService;
import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;
import designPattern.behavior.state.design.State;

public class CloseState extends State {
    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭中不可编辑");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭中不可审核通过");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭中不可审核拒绝");
    }

    @Override
    public Result checkResolve(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭中不可审核撤销");
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭活动关闭无效");
    }

    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Open);
        return new Result("0000", "活动开启成功");
    }

    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "关闭中不可执行活动中变更");
    }
}
