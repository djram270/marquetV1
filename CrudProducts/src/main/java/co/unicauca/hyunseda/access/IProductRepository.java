
package co.unicauca.hyunseda.access;

import co.unicauca.hyunseda.domain.entities.Product;
import java.util.List;

public interface IProductRepository {
    boolean save(Product newProduct);
    
    List<Product> findAllProducts(); 
    
    boolean edit(Long id, Product product);
    
    boolean delete(Long id);
    
    Product findById(Long id);
    
    Product findByName(String name);
}
