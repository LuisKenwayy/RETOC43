package co.luis.kenway.ciclo4.reto33.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.luis.kenway.ciclo4.reto33.Documents.Product;
import co.luis.kenway.ciclo4.reto33.repository.crud.ProductCrudRepository;


@Repository
public class ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    public Product create(Product product) {
        return productCrudRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productCrudRepository.findAll();
    }

    public Optional<Product> getProductByReference(String reference) {
        return productCrudRepository.findProdcutByReference(reference);
    }

    public void deleteProduct(Product product) {
        productCrudRepository.delete(product);
    }

    

}
