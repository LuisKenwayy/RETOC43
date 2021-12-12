package co.luis.kenway.ciclo4.reto33.repository.crud;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.luis.kenway.ciclo4.reto33.Documents.Product;

public interface ProductCrudRepository extends MongoRepository<Product, String> {

    // SELECT * FROM BOOKS WHERE id = ? -> SQL
    @Query("{reference:?0}")
    Optional<Product> findProdcutByReference(String reference);

}
