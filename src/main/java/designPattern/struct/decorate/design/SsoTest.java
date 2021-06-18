package designPattern.struct.decorate.design;

import designPattern.struct.decorate.base.SsoInterceptor;

public class SsoTest {
    public static void main(String[] args) {
        LoginSsoDecorator decorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "lsuccesshuahua";
        boolean success = decorator.preHandle(request, "123", "123");
        System.out.println("登录校验： " + request +(success ? " 放行" : " 拦截"));
    }
}
