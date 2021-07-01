package designPattern.behavior.state.design;

import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;

public abstract class State {
    /**
     * 活动提审
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result arraignment(String activityId, Enum<Status> currentStatus);

    /**
     * 审核通过
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkPass(String activityId, Enum<Status> currentStatus);

    /**
     * 审核拒绝
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkRefuse(String activityId, Enum<Status> currentStatus);

    /**
     * 审核撤销
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result checkResolve(String activityId, Enum<Status> currentStatus);

    /**
     * 活动关闭
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result close(String activityId, Enum<Status> currentStatus);

    /**
     * 活动开启
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result open(String activityId, Enum<Status> currentStatus);

    /**
     * 活动执行
     * @param activityId
     * @param currentStatus
     * @return
     */
    public abstract Result doing(String activityId, Enum<Status> currentStatus);
}
