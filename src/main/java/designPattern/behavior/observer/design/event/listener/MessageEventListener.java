package designPattern.behavior.observer.design.event.listener;

import designPattern.behavior.observer.base.LotteryResult;

public class MessageEventListener implements EventListener{

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {0} 发送短信通知：{1}", result.getuId(), result.getMsg());
    }
}
