package designPattern.behavior.observer.design.event.listener;

import designPattern.behavior.observer.base.LotteryResult;

public class MQEventListener implements EventListener{
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {0} 摇号结果： {1}", result.getuId(), result.getMsg());
    }
}
