
package co.unicauca.hyunseda;

import co.unicauca.hyunseda.access.ProductRepository;
import co.unicauca.hyunseda.presentation.GUICart;
import co.unicauca.hyunseda.presentation.GUIProductsCart;
import co.unicauca.hyunseda.domain.services.ProductService;
import co.unicauca.hyunseda.domain.services.ShoppingCartService;
import co.unicauca.hyunseda.presentation.GUIAddProduct;
import co.unicauca.hyunseda.presentation.GUIPago;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        shoppingCartService.getShoppingCart();//sujeto
         
        ProductRepository repository = new ProductRepository();
        ProductService productService = new ProductService(repository);
        
        
        GUIProductsCart instance = new GUIProductsCart(productService, shoppingCartService);
        instance.setVisible(true);
        
        GUIAddProduct gui = new GUIAddProduct(shoppingCartService);
        
        GUICart GUCart = new GUICart(shoppingCartService);//observer
        GUCart.setSize(300, 200);
        GUCart.setVisible(true);
        
        shoppingCartService.addObserver(GUCart);
        
        productService.saveProduct("Producto 1", "Descripción del Producto 1");
        productService.saveProduct("Producto 2", "Descripción del Producto 2");
        productService.saveProduct("Producto 3", "Descripción del Producto 3");*/
        GUIPago pau = new GUIPago();
        pau.setSize(300, 200);
        pau.setVisible(true);
    }
    
}
