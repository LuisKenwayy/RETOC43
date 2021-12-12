package co.luis.kenway.ciclo4.reto33.web_controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.luis.kenway.ciclo4.reto33.Documents.Product;
import co.luis.kenway.ciclo4.reto33.exceptions.ResourceNotFoundException;
import co.luis.kenway.ciclo4.reto33.service.ProductService;

import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
    RequestMethod.PUT })

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        try {
            Product newProduct = productService.create(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{reference}")
    public Product getProductByReference(@PathVariable("reference") String reference){
        return productService.getProduct(reference);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            Product updateProduct = productService.update(product);
            return new ResponseEntity<>(updateProduct, HttpStatus.CREATED) ;
        } catch (Exception e) {
            
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @DeleteMapping("/{reference}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("reference") String reference){
        try {
            productService.getProduct(reference);
            productService.deleteProduct(reference);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT) ;
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND) ;
        }catch(Exception er){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    
}
