package pojo;

public class Orders {

    private int id;
    private int user_id;
    private String name;         
    private double total_amount;
    private String order_date;
    private String status;

    // Constructor for USER
    public Orders(int id, double total_amount, String order_date, String status) {
        this.id = id;
        this.total_amount = total_amount;
        this.order_date = order_date;
        this.status = status;
    }

    
 // Constructor for ADMIN (with user_id also)
    public Orders(int id, int user_id, String name, double total_amount, String order_date, String status) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.total_amount = total_amount;
        this.order_date = order_date;
        this.status = status;
    }

    // GETTERS (VERY IMPORTANT FOR JSP)

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getStatus() {
        return status;
    }

    // SETTERS (optional but good)

    public void setStatus(String status) {
        this.status = status;
    }
}