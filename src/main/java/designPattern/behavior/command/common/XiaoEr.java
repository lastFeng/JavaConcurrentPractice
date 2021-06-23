package designPattern.behavior.command.common;

import com.alibaba.fastjson.JSON;
import designPattern.util.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XiaoEr {
    private Logger logger = new Logger();

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<>();

    public void order(int cuisine) {
        // 广东（粤菜）
        if (1 == cuisine) {
            cuisineMap.put(1, "粤菜");
        }

        if (2 == cuisine) {
            cuisineMap.put(2, "苏菜");
        }

        if (3 == cuisine) {
            cuisineMap.put(3, "鲁菜");
        }

        if (4 == cuisine) {
            cuisineMap.put(4, "川菜");
        }
    }

    public void placeOrder() {
        logger.info("菜单 {0}", JSON.toJSONString(cuisineMap));
    }

}
