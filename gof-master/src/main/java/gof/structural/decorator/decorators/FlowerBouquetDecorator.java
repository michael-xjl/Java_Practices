package gof.structural.decorator.decorators;


import gof.structural.decorator.components.FlowerBouquet;

public abstract class FlowerBouquetDecorator extends FlowerBouquet {
    public abstract String getDescription();
}
