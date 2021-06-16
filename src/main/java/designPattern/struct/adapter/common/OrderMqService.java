package designPattern.struct.adapter.common;

import com.alibaba.fastjson.JSON;
import designPattern.struct.adapter.base.mq.OrderMq;

public class OrderMqService {
    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... 处理自己的业务
    }
}
