package designPattern.behavior.chain.common;

import designPattern.behavior.chain.base.AuthInfo;
import designPattern.behavior.chain.base.AuthService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthController {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) {
            return new AuthInfo("0001", "order:", orderId, " 状态：待三级审批负责人 ", "老王");
        }

        if (authDate.after(format.parse("2021-06-01 00:00:00")) && authDate.before(format.parse("2021-06-25 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000012", orderId);
            if (null == date) {
                return new AuthInfo("0001", "order:", orderId, " 状态：待二级审批负责人 ", "老张");
            }
        }

        if (authDate.after(format.parse("2021-06-10 00:00:00")) && authDate.before(format.parse("2021-06-20 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000011", orderId);
            if (null == date) {
                return new AuthInfo("0001", "order:", orderId, " 状态：待一级审批负责人 ", "老段");
            }
        }
        return new AuthInfo("0001", "order:", orderId, " 状态：审批完成");
    }
}
