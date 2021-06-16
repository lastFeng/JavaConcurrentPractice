package designPattern.struct.adapter.common;

import designPattern.struct.adapter.base.mq.CreateAccount;
import designPattern.util.Logger;

public class CreateAccountMqService {
    private Logger logger = new Logger();

    public void onMessage(String message) {

//        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);
//
//        mq.getNumber();
//        mq.getAccountDate();

        // ... 处理自己的业务
    }
}
