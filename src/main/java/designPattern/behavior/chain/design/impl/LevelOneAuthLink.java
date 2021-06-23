package designPattern.behavior.chain.design.impl;

import designPattern.behavior.chain.base.AuthInfo;
import designPattern.behavior.chain.base.AuthService;
import designPattern.behavior.chain.design.AuthLink;

import java.util.Date;

public class LevelOneAuthLink extends AuthLink {

    public LevelOneAuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "order:", orderId," 状态：待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "order:", orderId, " 状态：一级审批完成 时间", format.format(date),
                    " 审批人: ", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}
