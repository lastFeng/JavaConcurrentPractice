package designPattern.behavior.visitor.design.user;

import designPattern.behavior.visitor.design.visitor.Visitor;
import designPattern.util.Logger;

public abstract class User {

    protected Logger logger = new Logger();

    public String name;      // 姓名
    public String identity;  // 身份；重点班、普通班 | 特级教师、普通教师、实习教师
    public String clazz;     // 班级

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    // 核心访问方法
    public abstract void accept(Visitor visitor);
}
