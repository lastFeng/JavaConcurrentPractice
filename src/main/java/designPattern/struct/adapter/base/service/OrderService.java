package designPattern.struct.adapter.base.service;

import designPattern.util.Logger;

public class OrderService {
    private Logger logger = new Logger();

    public long queryUserOrderCount(String userId){
        logger.info("自营商家，查询用户的订单是否为首单：{0}", userId);
        return 10L;
    }
}
