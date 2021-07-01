package designPattern.behavior.observer.common;

import designPattern.behavior.observer.base.LotteryResult;
import designPattern.behavior.observer.base.MinibusTargetService;

import java.util.Date;

public class LotteryServiceImpl implements LotteryService{
    private MinibusTargetService minibusTargetService = new MinibusTargetService();
    @Override
    public LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        logger.info("给用户 {0} 发短信，{1}", uId, lottery);
        logger.info("给用户 {0} 发其他通知，{1}", uId, lottery);
        return new LotteryResult(uId, lottery, new Date());
    }
}
