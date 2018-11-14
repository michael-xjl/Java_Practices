package gof.creational.abstractFactory;

import gof.creational.abstractFactory.topping.Cheese;
import gof.creational.abstractFactory.topping.Sauce;

public abstract class BaseToppingFactory {
    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}
