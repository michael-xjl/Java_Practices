package gof.creational.builder.solution1.director;

import gof.creational.builder.solution1.builders.HouseBuilder;
import gof.creational.builder.solution1.builders.ConcreteHouseBuilder;
import gof.creational.builder.solution1.builders.PrefabricatedHouseBuilder;
import gof.creational.builder.solution1.product.House;
import org.junit.Test;

public class ConstructionEngineerTest {

    @Test
    public void testConstructHouse() throws Exception {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineerA = new ConstructionEngineer(concreteHouseBuilder);
        House houseA = engineerA.constructHouse();
        System.out.println("House is: "+houseA);
        PrefabricatedHouseBuilder prefabricatedHouseBuilder = new PrefabricatedHouseBuilder();
        ConstructionEngineer engineerB = new ConstructionEngineer(prefabricatedHouseBuilder);
        House houseB = engineerB.constructHouse();
        System.out.println("House is: "+houseB);
    }
}