package co.luis.kenway.ciclo4.reto33.Documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Product {
    @Id
    private String reference;
    private String category;
    private String description;
    private boolean availability;
    private Double price;
    private int quantity;
    private String photography;

    public Product() {

    }

    public Product(Integer id, String reference, String category, String description, Boolean availability,
            Double price, Integer quantity, String photography) {
        this.reference = reference;
        this.category = category;
        this.description = description;
        this.availability = availability;
        this.price = price;
        this.quantity = quantity;
        this.photography = photography;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotography() {
        return photography;
    }

    public void setPhotography(String photography) {
        this.photography = photography;
    }

}
