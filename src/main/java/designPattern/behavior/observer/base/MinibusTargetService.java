package designPattern.behavior.observer.base;

public class MinibusTargetService {
    /**
     * 模拟摇号
     * @param uId
     * @return
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "Yes ".concat(uId).concat(" you get!") : "No ".concat(uId).concat(" sorry~");
    }
}
