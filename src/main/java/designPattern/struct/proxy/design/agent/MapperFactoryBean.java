package designPattern.struct.proxy.design.agent;

import designPattern.util.Logger;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger logger = new Logger();

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
          Select select = method.getAnnotation(Select.class);
          logger.info("SQL:{0}", select.value().replace("#{uId}", args[0].toString()));
          return args[0] + "-嘿嘿嘿";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
