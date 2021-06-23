package designPattern.behavior.command.design.cuisine.impl;

import designPattern.behavior.command.design.cook.ICook;
import designPattern.behavior.command.design.cuisine.ICuisine;

public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
