package chapter4;

import annotation.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class NumberRange {
    // 不变约束 lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    /***
     * 设置的时候，可能会存在不安全的情况
     * @param i
     */
    public void setLower(int i) {
        // 不全的“检查再运行”
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i +" > upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // 不全的“检查再运行”
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i +" < lower");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get() && i <= upper.get());
    }
}
