package pojo;

public class Cart {

    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Cart(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public double getTotal() {
        return price * quantity;
    }
}