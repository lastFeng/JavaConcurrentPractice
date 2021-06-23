package designPattern.struct.flyweight.design;

import designPattern.struct.flyweight.base.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActivityFactory {
    static Map<Long, Activity> activityMap = new HashMap<>();

    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);

        if (activity == null) {
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("Heihei");
            activity.setDesc("Heihei");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }

        return activity;
    }
}
