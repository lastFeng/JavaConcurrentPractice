package chapter16;

import annotation.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class SafeStates {

    // use final
    // and only initialization in construct and other method just get the value
    // although use the unsafe hashmap, can make sure the safe in multi-thread
    private final Map<String, String> states;

    public SafeStates() {
        states = new HashMap<>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String key) {
        return states.get(key);
    }
}
