package gof.creational.builder.solution2.builders;

import gof.creational.builder.solution2.product.House;

public class PrefabricatedHouseBuilder implements HouseBuilder
{
    private House house;

    public PrefabricatedHouseBuilder() {
        this.house = new House();
    }
    @Override
    public HouseBuilder buildFoundation() {
        house.setFoundation("Wood, laminate, and PVC flooring");
        System.out.println("PrefabricatedHouseBuilder: Foundation complete...");
        return this;
    }
    @Override
    public HouseBuilder buildStructure(){
        house.setStructure("Structural steels and wooden wall panels");
        System.out.println("PrefabricatedHouseBuilder: Structure complete...");
        return this;
    }
    @Override
    public HouseBuilder buildRoof(){
        house.setRoof("Roofing sheets");
        System.out.println("PrefabricatedHouseBuilder: Roof complete...");
        return this;

    }
    @Override
    public HouseBuilder paintHouse(){
        house.setPainted(false);
        System.out.println("PrefabricatedHouseBuilder: Painting not required...");
        return this;

    }
    @Override
    public HouseBuilder furnishHouse(){
        house.setFurnished(true);
        System.out.println("PrefabricatedHouseBuilder: Furnishing complete...");
        return this;

    }
    public House getHouse() {
        System.out.println("PrefabricatedHouseBuilder: Prefabricated house complete...");
        return this.house;
    }
}
