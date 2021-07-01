package designPattern.behavior.observer.design.event.listener;

import designPattern.behavior.observer.base.LotteryResult;
import designPattern.util.Logger;

public interface EventListener {
    Logger logger = new Logger();
    void doEvent(LotteryResult result);
}
