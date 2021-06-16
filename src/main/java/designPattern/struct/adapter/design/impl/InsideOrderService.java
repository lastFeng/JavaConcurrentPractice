package designPattern.struct.adapter.design.impl;

import designPattern.struct.adapter.base.service.OrderService;
import designPattern.struct.adapter.design.OrderAdapterService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
