package designPattern.behavior.chain.design;

import designPattern.behavior.chain.base.AuthInfo;
import designPattern.util.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AuthLink {
    protected Logger logger = new Logger();

    protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected String levelUserId;
    protected String levelUserName;
    protected AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
