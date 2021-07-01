package designPattern.behavior.observer.design;

import designPattern.behavior.observer.base.LotteryResult;
import designPattern.behavior.observer.base.MinibusTargetService;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService{

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        return new LotteryResult(uId, lottery, new Date());
    }
}
