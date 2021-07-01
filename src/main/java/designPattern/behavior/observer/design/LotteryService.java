package designPattern.behavior.observer.design;

import designPattern.behavior.observer.base.LotteryResult;
import designPattern.behavior.observer.design.event.EventManager;
import designPattern.behavior.observer.design.event.listener.MQEventListener;
import designPattern.behavior.observer.design.event.listener.MessageEventListener;
import designPattern.util.Logger;

public abstract class LotteryService {
    private EventManager eventManager;

    protected Logger logger = new Logger();

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);

        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
