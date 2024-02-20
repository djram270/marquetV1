
package co.com.hyunseda.market.access;

import co.com.hyunseda.market.service.Product;
import java.util.List;

public interface IProductRepository {
    boolean save(Product newProduct);
    
    List<Product> findAllProducts(); 
    
    boolean edit(Long id, Product product);
    
    boolean delete(Long id);
    
    Product findById(Long id);
}
