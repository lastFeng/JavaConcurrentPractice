package designPattern.behavior.state.design;

import designPattern.behavior.state.base.Result;
import designPattern.behavior.state.base.Status;
import designPattern.behavior.state.design.event.CloseState;
import designPattern.behavior.state.design.event.EditingState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateHandler {
    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<>();

    public StateHandler() {
        stateMap.put(Status.Close, new CloseState());
        stateMap.put(Status.Editing, new EditingState());
    }

    /**
     * 活动提审
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    /**
     * 审核通过
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    /**
     * 审核拒绝
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    /**
     * 审核撤销
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result checkResolve(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkResolve(activityId, currentStatus);
    }

    /**
     * 活动关闭
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    /**
     * 活动开启
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result open(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    /**
     * 活动执行
     * @param activityId
     * @param currentStatus
     * @return
     */
    public Result doing(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }
}
