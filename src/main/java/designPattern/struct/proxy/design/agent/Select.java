package designPattern.struct.proxy.design.agent;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default ""; // sql语句
}
