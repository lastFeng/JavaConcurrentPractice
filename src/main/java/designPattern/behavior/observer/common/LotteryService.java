package designPattern.behavior.observer.common;

import designPattern.behavior.observer.base.LotteryResult;
import designPattern.util.Logger;

public interface LotteryService {
    Logger logger = new Logger();

    LotteryResult doDraw(String uId);
}
