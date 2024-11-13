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

public class MiniP {

    public static void main(String[] args) {

    }
    
}
