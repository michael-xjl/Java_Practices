package gof.structural.decorator.decorators;

import gof.structural.decorator.components.FlowerBouquet;

public class RibbonBow extends FlowerBouquetDecorator{
    FlowerBouquet flowerBouquet;
    public RibbonBow(FlowerBouquet flowerBouquet){
        this.flowerBouquet=flowerBouquet;
    }
    public  String getDescription(){
        return flowerBouquet.getDescription()+", ribbon bow";
    }
    public double cost()
    {
        return 6.5+flowerBouquet.cost();
    }
}
