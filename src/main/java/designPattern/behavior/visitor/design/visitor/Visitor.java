package designPattern.behavior.visitor.design.visitor;

import designPattern.behavior.visitor.design.user.impl.Student;
import designPattern.behavior.visitor.design.user.impl.Teacher;
import designPattern.util.Logger;

public interface Visitor {
    Logger logger = new Logger();
    // 访问学生信息
    void visit(Student student);

    // 访问老师信息
    void visit(Teacher teacher);
}
