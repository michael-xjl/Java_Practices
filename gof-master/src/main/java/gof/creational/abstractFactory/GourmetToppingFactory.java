package gof.creational.abstractFactory;

import gof.creational.abstractFactory.topping.CaliforniaOilSauce;
import gof.creational.abstractFactory.topping.Cheese;
import gof.creational.abstractFactory.topping.GoatCheese;
import gof.creational.abstractFactory.topping.Sauce;

public class GourmetToppingFactory extends BaseToppingFactory{
    @Override
    public Cheese createCheese(){return new GoatCheese();}
    @Override
    public Sauce createSauce(){return new CaliforniaOilSauce();}
}
