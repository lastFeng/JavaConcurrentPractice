package designPattern.behavior.command.design.cook.impl;

import designPattern.behavior.command.design.cook.ICook;
import designPattern.util.Logger;

public class JiangSuCook implements ICook {

    private Logger logger = new Logger();

    @Override
    public void doCooking() {
        logger.info("{0}", "江苏苏菜");
    }
}
