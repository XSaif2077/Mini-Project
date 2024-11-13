package minip;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Product {
    private String productId;
    private String productName;
    private String description;
    private String size;
    private String color;
    private double price;
    private int stock;

    public Product(String productId, String productName, String description, String size, String color, double price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscountedPrice(double discountRate) {
        return price * (1 - discountRate / 100);
    }

    public String getProductName() {
        return productName;
    }

  public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class Material {
    private String materialId;
    private String fabricType;
    private String color;
    private double costPerMeter;

    public Material(String materialId, String fabricType, String color, double costPerMeter) {
        this.materialId = materialId;
        this.fabricType = fabricType;
        this.color = color;
        this.costPerMeter = costPerMeter;
    }

    public double calculateTotalCost(double meters) {
        return costPerMeter * meters;
    }
}

class Vendor {
    private String vendorId;
    private String vendorName;
    private String contactDetails;
    private List<Material> availableMaterials = new ArrayList<>();

    public Vendor(String vendorId, String vendorName, String contactDetails) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contactDetails = contactDetails;
    }

public class MiniP {

    public static void main(String[] args) {

    }
    
}
