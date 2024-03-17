package co.unicauca.hyunseda.domain.services;


import co.unicauca.hyunseda.domain.entities.Product;
import co.unicauca.hyunseda.access.IProductRepository;
import java.util.ArrayList;
import java.util.List;

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
    
    public Product findProductByName(String name){
        return repository.findByName(name);
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
