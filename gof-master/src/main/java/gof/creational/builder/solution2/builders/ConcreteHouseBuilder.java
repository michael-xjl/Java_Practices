package gof.creational.builder.solution2.builders;

import gof.creational.builder.solution2.product.House;

public class ConcreteHouseBuilder implements HouseBuilder
{
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }
    @Override
    public HouseBuilder buildFoundation() {
        house.setFoundation("Concrete, brick, and stone");
        System.out.println("ConcreteHouseBuilder: Foundation complete...");
        return this;
    }
  @Override
    public HouseBuilder buildStructure(){
      house.setStructure("Concrete, mortar, brick, and reinforced steel");
      System.out.println("ConcreteHouseBuilder: Structure complete...");
      return this;
  }
    @Override
    public HouseBuilder buildRoof(){
      house.setRoof("Concrete and reinforced steel");
        System.out.println("ConcreteHouseBuilder: Roof complete...");
        return this;
    }
    @Override
    public HouseBuilder paintHouse(){
      house.setPainted(true);
        System.out.println("ConcreteHouseBuilder: Painting complete...");
        return this;
    }
    @Override
    public HouseBuilder furnishHouse(){
    house.setFurnished(true);
        System.out.println("ConcreteHouseBuilder: Furnishing complete...");
        return this;
    }
    public House getHouse() {
        System.out.println("ConcreteHouseBuilder: Concrete house complete...");
        return this.house;
    }


}
