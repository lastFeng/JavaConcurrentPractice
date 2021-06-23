package designPattern.behavior.chain.design.impl;

import designPattern.behavior.chain.base.AuthInfo;
import designPattern.behavior.chain.base.AuthService;
import designPattern.behavior.chain.design.AuthLink;

import java.text.ParseException;
import java.util.Date;

public class LevelTwoAuthLink extends AuthLink {
    private Date beginDate = format.parse("2021-06-01 00:00:00");
    private Date endDate = format.parse("2021-06-25 25:59:59");

    public LevelTwoAuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "order:", orderId, " 状态：待二级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next || authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "order:", orderId, " 状态：二级审批完成 时间", format.format(date),
                    " 审批人: ", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}
