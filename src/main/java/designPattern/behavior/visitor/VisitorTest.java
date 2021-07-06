package designPattern.behavior.visitor;

import designPattern.behavior.visitor.design.DataView;
import designPattern.behavior.visitor.design.visitor.impl.Parent;
import designPattern.behavior.visitor.design.visitor.impl.Principal;
import designPattern.util.Logger;

public class VisitorTest {

    private static Logger logger = new Logger();

    public static void main(String[] args) {
        DataView dataView = new DataView();
        logger.info("家长视角： ");
        dataView.show(new Parent());

        logger.info("校长视角：");
        dataView.show(new Principal());
    }
}
