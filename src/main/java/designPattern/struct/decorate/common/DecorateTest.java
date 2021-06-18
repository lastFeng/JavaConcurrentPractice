package designPattern.struct.decorate.common;

public class DecorateTest {
    public static void main(String[] args) {
        LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator();
        String request = "lsuccesshuahua";
        boolean success = loginSsoDecorator.preHandle(request, "hello", "123");
        System.out.println("登录校验： " + request + (success ? " 放行" : " 拦截"));
    }
}
