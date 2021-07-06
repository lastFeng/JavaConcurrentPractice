package designPattern.behavior.visitor.design.user.impl;

import designPattern.behavior.visitor.design.user.User;
import designPattern.behavior.visitor.design.visitor.Visitor;

import java.math.BigDecimal;

public class Teacher extends User {
    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
