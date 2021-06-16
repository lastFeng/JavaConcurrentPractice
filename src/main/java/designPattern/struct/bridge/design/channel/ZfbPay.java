package designPattern.struct.bridge.design.channel;

import designPattern.struct.bridge.design.mode.IPayMode;

import java.math.BigDecimal;

public class ZfbPay extends Pay{

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟支付宝渠道支付划账开始。uId：{0} tradeId：{1} amount：{2}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟支付宝渠道支付风控校验。uId：{0} tradeId：{1} security：{2}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟支付宝渠道支付划账拦截。uId：{0} tradeId：{1} amount：{2}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟支付宝渠道支付划账成功。uId：{0} tradeId：{1} amount：{2}", uId, tradeId, amount);
        return "0000";
    }
}
