package designPattern.struct.adapter.base.service;

import designPattern.util.Logger;

public class POPOrderService {
    private Logger logger = new Logger();

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询用户的订单是否为首单：{0}", uId);
        return true;
    }
}
