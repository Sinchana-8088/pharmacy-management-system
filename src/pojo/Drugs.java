package pojo;

public class Drugs {

    private int id;
    private String name;
    private int catergory_id;
    private double price;
    private double discount;
    private double final_price;
    private int stock;
    private String last_updated;
    

    
    public Drugs(int id, String name, int catergory_id,
                 double price, double discount,
                 double final_price, int stock, String last_updated) {

        this.id = id;
        this.name = name;
        this.catergory_id = catergory_id;
        this.price = price;
        this.discount = discount;
        this.final_price = final_price;
        this.stock = stock;
        this.last_updated = last_updated;
    }

   

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCatergory_id() {
        return catergory_id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinal_price() {
        return final_price;
    }

    public int getStock() {
        return stock;
    }
    public String getLast_updated() {
        return last_updated;
    }
}