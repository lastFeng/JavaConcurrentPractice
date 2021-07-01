package designPattern.behavior.observer.common;

import designPattern.behavior.observer.base.LotteryResult;

public class LotteryCommonTest {
    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("1111112");
        System.out.println("123: " + result.toString());
    }
}
