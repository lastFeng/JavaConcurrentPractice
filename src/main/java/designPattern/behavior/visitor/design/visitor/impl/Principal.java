package designPattern.behavior.visitor.design.visitor.impl;

import designPattern.behavior.visitor.design.user.impl.Student;
import designPattern.behavior.visitor.design.user.impl.Teacher;
import designPattern.behavior.visitor.design.visitor.Visitor;

public class Principal implements Visitor {
    @Override
    public void visit(Student student) {
        logger.info("学生信息 姓名：{0} 班级：{1}", student.name, student.clazz);
    }

    @Override
    public void visit(Teacher teacher) {
        logger.info("老师信息 姓名：{0}， 班级：{1}， 升学率：{2}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }
}
