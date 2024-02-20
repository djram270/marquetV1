package co.com.hyunseda.market.service;


import co.com.hyunseda.market.access.IProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Samuel Guilombo Gomez, Oscar Andres Tosne Perez
 */
public class ProductService {


    private IProductRepository repository;
   
    public ProductService(IProductRepository repository) {
        this.repository = repository;
        //NO debe haber NEW
    }

    public boolean saveProduct(String name,String description) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setDescription(description);

        //Validate product
        if (newProduct.getName().isEmpty() ) {
            return false;
        }
        return repository.save(newProduct);
    }

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAllProducts();

        return products;
    }
    
    
    //Ver si le puede llegar un producto
    public Product findProductById(Long id){
        return repository.findById(id);
    }
    
    public boolean deleteProduct(Long id){
        return repository.delete(id);
    }

    public boolean editProduct(Long productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getName().isEmpty() ) {
            return false;
        }
        return repository.edit(productId, prod);
    }

}
