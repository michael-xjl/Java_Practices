package gof.creational.builder.solution2.director;

import gof.creational.builder.solution2.builders.HouseBuilder;
import gof.creational.builder.solution2.product.House;

public class ConstructionEngineer {
    private HouseBuilder houseBuilder;
    public ConstructionEngineer(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        return this.houseBuilder.buildFoundation().buildRoof().paintHouse().furnishHouse().getHouse();
    }
}
