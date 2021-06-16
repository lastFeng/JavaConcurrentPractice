package designPattern.struct.adapter.design.impl;

import designPattern.struct.adapter.base.service.POPOrderService;
import designPattern.struct.adapter.design.OrderAdapterService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
