package gof.structural.facade.subcomponents;


import gof.structural.facade.domain.Product;

public class InventoryService {
    public static boolean isAvailable(Product product){
        /*Check Warehouse database for product availability*/
        return true;
    }
}
