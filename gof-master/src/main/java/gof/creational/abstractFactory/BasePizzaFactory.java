package gof.creational.abstractFactory;


import gof.creational.abstractFactory.product.Pizza;

public abstract class BasePizzaFactory {
    
    public abstract Pizza createPizza(String type);
}
