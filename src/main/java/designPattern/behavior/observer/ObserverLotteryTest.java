package designPattern.behavior.observer;

import designPattern.behavior.observer.design.LotteryService;
import designPattern.behavior.observer.design.LotteryServiceImpl;

public class ObserverLotteryTest {
    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        lotteryService.draw("1111111");
        lotteryService.draw("1111112");
    }
}
