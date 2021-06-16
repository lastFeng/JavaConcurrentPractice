package designPattern.struct.bridge.design.mode;

import designPattern.util.Logger;

public class PayFingerprintMode implements IPayMode{
    private Logger logger = new Logger();
    @Override
    public boolean security(String uId) {
        logger.info("指纹支付，风控校验环境安全");
        return true;
    }
}
