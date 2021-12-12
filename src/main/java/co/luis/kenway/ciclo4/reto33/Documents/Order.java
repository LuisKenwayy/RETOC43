package co.luis.kenway.ciclo4.reto33.Documents;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;

    private Map<String, Product> products;
    private Map<String, Integer> quantities;

    

    public Order() {
    }




    public Order(Integer id, Date registerDay, String status, User salesMan, Map<String, Product> products,
            Map<String, Integer> quantities) {
        this.id = id;
        this.registerDay = registerDay;
        this.status = status;
        this.salesMan = salesMan;
        this.products = products;
        this.quantities = quantities;
    }







    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public Date getRegisterDay() {
        return registerDay;
    }



    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    public User getSalesMan() {
        return salesMan;
    }



    public void setSalesMan(User salesMan) {
        this.salesMan = salesMan;
    }



    public Map<String, Product> getProducts() {
        return products;
    }



    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }



    public Map<String, Integer> getQuantities() {
        return quantities;
    }



    public void setQuantities(Map<String, Integer> quantities) {
        this.quantities = quantities;
    }


    

    
}
