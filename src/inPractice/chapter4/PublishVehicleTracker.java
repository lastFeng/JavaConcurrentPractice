package inPractice.chapter4;

import inPractice.annotation.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class PublishVehicleTracker {
    private Map<String, SafePoint> locations;
    private Map<String, SafePoint> unmodifiableMap;

    public PublishVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String key) {
        return locations.get(key);
    }

    public void setLocations(String key, int x, int y) {
        if (!locations.containsKey(key)) {
            throw new IllegalArgumentException("Invalid Vehicle name: " + key);
        }

        // set 是synchronized，所以是安全的
        locations.get(key).set(x, y);
    }
}
