
package co.unicauca.hyunseda.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<ItemShoppingCart> items;

    private ShoppingCart() {
        
    }
    
    public static List<ItemShoppingCart> getShopppingCart(){
        if (items == null) {
            items = new ArrayList<>();
        } 
        return items;
    }

    public static void addItem(ItemShoppingCart item) {
        items.add(item);
    }
    
    public static void cleanItems(){
        items = null;
    }
}
