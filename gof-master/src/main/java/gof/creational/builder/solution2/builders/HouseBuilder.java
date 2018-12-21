package gof.creational.builder.solution2.builders;

import gof.creational.builder.solution2.product.House;

public interface HouseBuilder {
    HouseBuilder buildFoundation();
    HouseBuilder buildStructure();
    HouseBuilder buildRoof();
    HouseBuilder paintHouse();
    HouseBuilder furnishHouse();
    House getHouse();
}
