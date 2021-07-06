package designPattern.behavior.visitor.design.visitor.impl;

import designPattern.behavior.visitor.design.user.impl.Student;
import designPattern.behavior.visitor.design.user.impl.Teacher;
import designPattern.behavior.visitor.design.visitor.Visitor;

public class Parent implements Visitor {

    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{0} 班级：{1}，排名：{2}", student.name, student.clazz, student.ranking());
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{0}， 班级：{1}, 级别：{2}", teacher.name, teacher.clazz, teacher.identity);
    }
}
