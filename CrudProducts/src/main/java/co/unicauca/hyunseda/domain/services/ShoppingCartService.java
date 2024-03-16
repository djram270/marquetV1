
package co.unicauca.hyunseda.domain.services;

import co.unicauca.hyunseda.domain.entities.ItemShoppingCart;
import co.unicauca.hyunseda.domain.entities.ShoppingCart;
import co.unicauca.hyunseda.infra.Subject;
import java.util.List;

public class ShoppingCartService extends Subject{
    
    public ShoppingCartService(){
        
    }

    public List<ItemShoppingCart> getShoppingCart() {
        return ShoppingCart.getShopppingCart();
    }
    
    public void setShoppingCart(ItemShoppingCart item)
    {
        ShoppingCart.addItem(item);
        this.notifyAllObserves();
    }
    
    public void cleanShoppingCart()
    {
        ShoppingCart.cleanItems();
        ShoppingCart.getShopppingCart();
        this.notifyAllObserves();
        
    }
   /*
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAllProducts();

        return products;
    }*/
}
