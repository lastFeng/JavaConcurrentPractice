package designPattern.struct.composite.common;

import designPattern.util.Logger;

public class EngineTest {
    private static Logger logger = new Logger();
    public static void main(String[] args) {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        logger.info("测试结果： {0}", process);
    }
}
