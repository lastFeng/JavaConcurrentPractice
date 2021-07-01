package designPattern.behavior.state.base;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityService {
    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    /**
     * 初始化
     * @param activityId
     * @param status
     */
    public static void init(String activityId, Enum<Status> status) {
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("Hello");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {
        ActivityInfo info = new ActivityInfo();
        info.setActivityId(activityId);
        info.setActivityName("Hello");
        info.setStatus(statusMap.get(activityId));
        info.setBeginTime(new Date());
        info.setEndTime(new Date());
        return info;
    }

    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }
}
