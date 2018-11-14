package gof.creational.abstractFactory;

import gof.creational.abstractFactory.topping.Cheese;
import gof.creational.abstractFactory.topping.MozzarellaCheese;
import gof.creational.abstractFactory.topping.Sauce;
import gof.creational.abstractFactory.topping.TomatoSauce;

public class SicilianToppingFactory extends BaseToppingFactory{
    @Override
    public  Cheese createCheese(){return new MozzarellaCheese();}
    @Override
    public  Sauce createSauce(){return new TomatoSauce();}
}
