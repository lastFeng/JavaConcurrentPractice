package designPattern.struct.decorate.base;

public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}
