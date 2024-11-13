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

    public void addMaterial(Material material) {
        availableMaterials.add(material);
    }

    public List<Material> listMaterials() {
        return availableMaterials;
    }
}

class Order {
    private String orderNumber;
    private Date orderDate;
    private List<Product> items = new ArrayList<>();
    private double totalAmount;

    public Order(String orderNumber, Date orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

     public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotal(double discountRate) {
        totalAmount = 0;
        for (Product item : items) {
            totalAmount += item.getDiscountedPrice(discountRate);
        }
        return totalAmount;
    }

     public void displayOrderSummary(Customer customer, double discountRate) {
        System.out.println("----- Invoice -----");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone: " + customer.getPhone());
        System.out.println("Order ID: " + orderNumber);
        System.out.println("Order Date: " + orderDate);
        
        for (Product item : items) {
            System.out.println("Item: " + item.getProductName() + " | Original Price: " + item.getPrice() +
                               " | Discounted Price: " + item.getDiscountedPrice(discountRate) +
                               " | Description: " + item.getDescription());
        }

        System.out.println("Discount Applied: " + discountRate + "%");
        System.out.println("Total Amount: " + calculateTotal(discountRate));
        System.out.println("-------------------");
    }
}

class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void makeOrder(Order order, double discountRate) {
        order.displayOrderSummary(this, discountRate);
        System.out.println("Order placed successfully!");
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productId) {
         products.removeIf(p -> p.productId.equals(productId));
    }

    public Product searchProduct(String productId) {
        for (Product p : products) {
            if (p.productId.equals(productId)) {
                return p;
            }
        }
        return null;
    }
}

public class MiniP {

    public static void main(String[] args) {

        Product shirt = new Product("P1", "Silk Shirt", "High-quality silk shirt", "L", "Blue", 600, 10);
        Product trousers = new Product("P2", "Cotton Trousers", "Comfortable cotton trousers", "M", "Black", 400, 20);

        Order order = new Order("O1001", new Date());
        order.addProduct(shirt);
        order.addProduct(trousers);

        Customer customer = new Customer("C1001", "Jane Smith", "jane@example.com", "9876543210");

        // Customer places an order with a discount
        customer.makeOrder(order, 10);  // 10% discount
    }
}
