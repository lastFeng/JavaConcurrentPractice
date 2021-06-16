package designPattern.struct.bridge.design;

import designPattern.struct.bridge.design.channel.Pay;
import designPattern.struct.bridge.design.channel.WxPay;
import designPattern.struct.bridge.design.channel.ZfbPay;
import designPattern.struct.bridge.design.mode.PayFaceMode;
import designPattern.struct.bridge.design.mode.PayFingerprintMode;

import java.math.BigDecimal;

public class PayTest {
    public static void main(String[] args) {
        Pay pay;

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        pay = new WxPay(new PayFaceMode());
        pay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        pay = new ZfbPay(new PayFingerprintMode());
        pay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
    }
}
