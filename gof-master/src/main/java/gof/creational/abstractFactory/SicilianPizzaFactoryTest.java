package gof.creational.abstractFactory;

import gof.creational.abstractFactory.product.Pizza;
import org.junit.Test;

public class SicilianPizzaFactoryTest {

    @Test
    public void testCreatePizza() throws Exception {
        BasePizzaFactory pizzaFactory=new SicilianPizzaFactory();
        Pizza cheesePizza=pizzaFactory.createPizza("cheese");
        Pizza pepperoniPizza =pizzaFactory.createPizza("pepperoni");
    }
}