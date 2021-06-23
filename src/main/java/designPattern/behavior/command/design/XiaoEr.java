package designPattern.behavior.command.design;

import designPattern.behavior.command.design.cuisine.ICuisine;
import designPattern.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class XiaoEr {
    private Logger logger = new Logger();

    public List<ICuisine> cuisineList = new ArrayList<>();

    public void order(ICuisine iCuisine) {
        cuisineList.add(iCuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine iCuisine : cuisineList) {
            iCuisine.cook();
        }
        cuisineList.clear();
    }
}
