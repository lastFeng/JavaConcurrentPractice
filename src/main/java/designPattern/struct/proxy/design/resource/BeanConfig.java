package designPattern.struct.proxy.design.resource;

import designPattern.struct.proxy.design.agent.RegisterBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeanConfig {
    @Bean
    public RegisterBeanFactory userDao() {
        return new RegisterBeanFactory();
    }
}
