package designPattern.struct.bridge.design.channel;

import designPattern.struct.bridge.design.mode.IPayMode;
import designPattern.util.Logger;

import java.math.BigDecimal;

public abstract class Pay {

    protected Logger logger = new Logger();

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
