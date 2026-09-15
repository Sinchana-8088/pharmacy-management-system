package dbtransactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Cart;
import pojo.Doctor;
import pojo.Drugs;
import pojo.Categories;
import pojo.Orders;
import dbconnectivity.DatabaseConnection;

public class DbTransactions{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	public DbTransactions() {
		// TODO Auto-generated constructor stub
	}


	/*public int insertUser(String name, String email, String phone, String gender, String age, String password, String address, String pincode) {

	    con = DatabaseConnection.mydbconnection();

	    try {
	        ps = con.prepareStatement(
	            "INSERT INTO users(name,email,phone,gender,age,password,address,pincode) VALUES(?,?,?,?,?,?,?,?)",
	            Statement.RETURN_GENERATED_KEYS
	        );

	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setString(3, phone);
	        ps.setString(4, gender);
	        ps.setString(5, age);
	        ps.setString(6, password);
	        ps.setString(7, address);
	        ps.setString(8, pincode);

	        int rows = ps.executeUpdate();
	        System.out.println("Rows inserted: " + rows);

	        if (rows > 0) {
	            rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return 0;
	}
	
	
	public int checkUser(String email) {
		con = DatabaseConnection.mydbconnection();
		try {
			ps = con.prepareStatement("select * from users where email=?");
		    ps.setString(1, email);
			rs = ps.executeQuery();
			

	        if (rs.next()) {
	            return 1; 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    		return 0;
	}
		return 0;
	}*/
	
	 public int insertUser(String name, String email, String phone,
             String gender, String age, String password,
             String address, String pincode) {

try {
con = DatabaseConnection.mydbconnection();

String sql = "INSERT INTO users(name,email,phone,gender,age,password,address,pincode) VALUES(?,?,?,?,?,?,?,?)";

ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

ps.setString(1, name);
ps.setString(2, email);
ps.setString(3, phone);
ps.setString(4, gender);
ps.setString(5, age);
ps.setString(6, password);
ps.setString(7, address);
ps.setString(8, pincode);

int rows = ps.executeUpdate();
System.out.println("Rows inserted: " + rows);

if (rows > 0) {
   rs = ps.getGeneratedKeys();
   if (rs.next()) {
       return rs.getInt(1);
   }
}

} catch (Exception e) {
e.printStackTrace();
} finally {
try {
   if (rs != null) rs.close();
   if (ps != null) ps.close();
   if (con != null) con.close();
} catch (Exception e) {
   e.printStackTrace();
}
}

return 0;
}


public int checkUser(String email) {
	con = DatabaseConnection.mydbconnection();
	try {
		ps = con.prepareStatement("SELECT * FROM users WHERE email=?");
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
			return 1;
			}
		} catch (Exception e) {e.printStackTrace();}
	finally {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
			} catch (Exception e) {e.printStackTrace();}
		}
	return 0;
	}



	public int validateLtype(String email, String password, String logintype) {
	    con = DatabaseConnection.mydbconnection();

	    try {
	        if ("Admin".equals(logintype)) {
	            ps = con.prepareStatement("SELECT * FROM admin WHERE email=? AND password=?");
	        } 
	        else if ("User".equals(logintype)) {
	            ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
	        } 
	        else {
	            return 0;
	        }

	        ps.setString(1, email);
	        ps.setString(2, password);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return 1;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return 0;
	}

	public int InsertCategory(String name) {
		
		con = DatabaseConnection.mydbconnection();
		try {
			ps = con.prepareStatement("insert into categories(name)"+ "values(?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			rs = ps.getGeneratedKeys();
			ps.execute();
			if(rs.next()){
				return rs.getInt(1);
		}
	}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return 0;
	}


	public int checkcategory(String name) {
		con = DatabaseConnection.mydbconnection();
		try {
			ps = con.prepareStatement("select * from categories where name=?");
		    ps.setString(1, name);
			rs = ps.executeQuery();

	        if (rs.next()) {
	            return 1; 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    		return 0;
	}
		return 0;
	}



	public ArrayList<Categories> getcategorydetails() {
		con = DatabaseConnection.mydbconnection();
		ArrayList<Categories> li = new ArrayList<Categories>();

	    try {
	        ps = con.prepareStatement("select * from categories");
	        rs = ps.executeQuery();

	        while (rs.next()) {   
	            li.add(new Categories(rs.getInt("id"), rs.getString("name")));
	            
	        }return li;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return li;
	}


	public int checkDrug(String name) {
		con = DatabaseConnection.mydbconnection();
		try {
			ps = con.prepareStatement("select * from druginfo where name=?");
		    ps.setString(1, name);
			rs = ps.executeQuery();
	        if (rs.next()) {
	            return 1; 
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    		return 0;
	}
		return 0;
	}


	public int InsertDrug(String name, String catergory_id, String price,
			String discount, String stock) {
		con = DatabaseConnection.mydbconnection();
		try {
			double p = Double.parseDouble(price);
	        double d = Double.parseDouble(discount);
	        double final_price = p - d;

	        ps = con.prepareStatement(
	            "INSERT INTO druginfo(name, catergory_id, price, discount, final_price, stock, last_updated) VALUES(?,?,?,?,?,?,CURDATE())",
	            Statement.RETURN_GENERATED_KEYS
	        );

	        ps.setString(1, name);
	        ps.setInt(2, Integer.parseInt(catergory_id));
	        ps.setDouble(3, p);
	        ps.setDouble(4, d);
	        ps.setDouble(5, final_price);
	        ps.setInt(6, Integer.parseInt(stock));

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	
	public ArrayList<Drugs> getdrugsdetails() {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Drugs> li = new ArrayList<Drugs>();

	    try {
	        ps = con.prepareStatement("select * from druginfo");
	        rs = ps.executeQuery();

	        while (rs.next()) {

	        	li.add(new Drugs(
	        		    rs.getInt("id"),
	        		    rs.getString("name"),
	        		    rs.getInt("catergory_id"),
	        		    rs.getDouble("price"),
	        		    rs.getDouble("discount"),
	        		    rs.getDouble("final_price"),
	        		    rs.getInt("stock"),
	        		    rs.getDate("last_updated").toString()
	        		));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return li;
	}


	public int deletecategory(String id) {
		con = DatabaseConnection.mydbconnection();
		try {
	        ps = con.prepareStatement("DELETE FROM categories WHERE id=?");
	        ps.setString(1, id);

	        int i = ps.executeUpdate();
	        return i;

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            ps.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}


	public int getUserIdByEmail(String email) {
		if (email == null) return 0;

	    con = DatabaseConnection.mydbconnection();

	    try {
	        ps = con.prepareStatement("SELECT uid FROM users WHERE email=?");
	        ps.setString(1, email);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt("uid");  
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}


	public int addToCart(int user_id, int drug_id) {
		con = DatabaseConnection.mydbconnection();
		try {
	        ps = con.prepareStatement("SELECT * FROM cart WHERE user_id=? AND drug_id=?");
	        ps.setInt(1, user_id);
	        ps.setInt(2, drug_id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            // update quantity
	            ps = con.prepareStatement("UPDATE cart SET quantity=quantity+1 WHERE user_id=? AND drug_id=?");
	            ps.setInt(1, user_id);
	            ps.setInt(2, drug_id);
	            return ps.executeUpdate();
	        } else {
	            // insert new
	            ps = con.prepareStatement("INSERT INTO cart(user_id, drug_id, quantity) VALUES(?,?,1)");
	            ps.setInt(1, user_id);
	            ps.setInt(2, drug_id);
	            return ps.executeUpdate();
	        }

	    } catch(Exception e) { e.printStackTrace(); }
		
		return 0;
	}


	public ArrayList<Cart> getCartItems(int user_id) {
		con = DatabaseConnection.mydbconnection();
	    ArrayList<Cart> list = new ArrayList<>();

	    try {
	        ps = con.prepareStatement(
	            "SELECT c.id, d.name, d.final_price, c.quantity " +
	            "FROM cart c JOIN druginfo d ON c.drug_id=d.id WHERE c.user_id=?"
	        );
	        ps.setInt(1, user_id);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Cart(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getDouble("final_price"),
	                rs.getInt("quantity")
	            ));
	        }

	    } catch(Exception e) { e.printStackTrace(); }

	    return list;
	}


	public void placeOrder(int user_id) {

	    con = DatabaseConnection.mydbconnection();

	    try {
	        ps = con.prepareStatement(
	            "SELECT SUM(d.final_price * c.quantity) as total " +
	            "FROM cart c JOIN druginfo d ON c.drug_id=d.id WHERE c.user_id=?"
	        );
	        ps.setInt(1, user_id);
	        rs = ps.executeQuery();

	        double total = 0;

	        if (rs.next() && rs.getDouble("total") > 0) {
	            total = rs.getDouble("total");
	        } else {
	            System.out.println("Cart is empty");
	            return;
	        }

	        System.out.println("User ID: " + user_id);
	        System.out.println("Total: " + total);

	        ps = con.prepareStatement(
	            "INSERT INTO orders(user_id, total_amount, order_date, status) VALUES(?,?,NOW(),'PLACED')",
	            Statement.RETURN_GENERATED_KEYS
	        );
	        ps.setInt(1, user_id);
	        ps.setDouble(2, total);
	        ps.executeUpdate();

	        rs = ps.getGeneratedKeys();
	        int order_id = 0;

	        if (rs.next()) {
	            order_id = rs.getInt(1);
	        }

	        System.out.println("Order ID: " + order_id);

	        ps = con.prepareStatement(
	            "INSERT INTO order_items(order_id, drug_id, quantity, price) " +
	            "SELECT ?, drug_id, quantity, (quantity * d.final_price) " +
	            "FROM cart c JOIN druginfo d ON c.drug_id=d.id WHERE c.user_id=?"
	        );
	        ps.setInt(1, order_id);
	        ps.setInt(2, user_id);
	        ps.executeUpdate();

	        ps = con.prepareStatement("DELETE FROM cart WHERE user_id=?");
	        ps.setInt(1, user_id);
	        ps.executeUpdate();

	        System.out.println("Order placed successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public ArrayList<Orders> getOrders(int user_id) {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Orders> list = new ArrayList<>();

	    try {
	    	ps = con.prepareStatement(
	    		    "SELECT id, total_amount, order_date, status FROM orders WHERE user_id=? ORDER BY order_date DESC"
	    		);

	        ps.setInt(1, user_id);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	list.add(new Orders(
	        		    rs.getInt("id"),
	        		    rs.getDouble("total_amount"),
	        		    rs.getString("order_date"),
	        		    rs.getString("status")
	        		));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	public ArrayList<Orders> getAllOrders() {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Orders> list = new ArrayList<>();

	    try {
	        ps = con.prepareStatement(
	            "SELECT o.id, o.user_id, u.name, o.total_amount, o.order_date, o.status " +
	            "FROM orders o JOIN users u ON o.user_id = u.uid ORDER BY o.order_date DESC"
	        );

	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Orders(
	                rs.getInt("id"),
	                rs.getInt("user_id"),
	                rs.getString("name"),
	                rs.getDouble("total_amount"),
	                rs.getString("order_date"),
	                rs.getString("status")
	            ));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	public int updateOrderStatus(int order_id, String status) {

    con = DatabaseConnection.mydbconnection();

    try {
        ps = con.prepareStatement(
            "UPDATE orders SET status=? WHERE id=?"
        );

        ps.setString(1, status);
        ps.setInt(2, order_id);

        return ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}


	public int deleteDrug(String id) {
		con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("DELETE FROM druginfo WHERE id=?");
	        ps.setString(1, id);

	        int i = ps.executeUpdate();
	        return i;

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}
	
	public int updateDrug(String id, String category_id, String price,
            String discount, String stock) {

con = DatabaseConnection.mydbconnection();

try {
double p = Double.parseDouble(price);
double d = Double.parseDouble(discount);

double final_price = p - (p * d / 100);

ps = con.prepareStatement(
  "UPDATE druginfo SET catergory_id=?, price=?, discount=?, final_price=?, stock=?, last_updated=CURDATE() WHERE id=?"
);

ps.setInt(1, Integer.parseInt(category_id));
ps.setDouble(2, p);
ps.setDouble(3, d);
ps.setDouble(4, final_price);
ps.setInt(5, Integer.parseInt(stock));
ps.setInt(6, Integer.parseInt(id));

return ps.executeUpdate();

} catch (Exception e) {
e.printStackTrace();
}

return 0;
}
	
	public Drugs getDrugById(int id) {

	    con = DatabaseConnection.mydbconnection();

	    try {
	        ps = con.prepareStatement("SELECT * FROM druginfo WHERE id=?");
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new Drugs(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("catergory_id"),
	                rs.getDouble("price"),
	                rs.getDouble("discount"),
	                rs.getDouble("final_price"),
	                rs.getInt("stock"),
	                rs.getDate("last_updated").toString()
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public ArrayList<Drugs> filterDrugs(String category, String drugId, String sort) {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Drugs> list = new ArrayList<>();

	    try {
	        String query = "SELECT * FROM druginfo WHERE 1=1";

	        // CATEGORY FILTER
	        if (category != null && !category.isEmpty()) {
	            query += " AND catergory_id=" + category;
	        }

	        // DRUG FILTER
	        if (drugId != null && !drugId.isEmpty()) {
	            query += " AND id=" + drugId;
	        }

	        // SORTING
	        if ("asc".equals(sort)) {
	            query += " ORDER BY name ASC";
	        } 
	        else if ("desc".equals(sort)) {
	            query += " ORDER BY name DESC";
	        }

	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Drugs(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("catergory_id"),
	                rs.getDouble("price"),
	                rs.getDouble("discount"),
	                rs.getDouble("final_price"),
	                rs.getInt("stock"),
	                rs.getDate("last_updated").toString()
	            ));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	public ArrayList<Drugs> getLowStockDrugs() {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Drugs> list = new ArrayList<>();

	    try {
	    	ps = con.prepareStatement("SELECT * FROM druginfo WHERE stock < 10 ORDER BY stock ASC");
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Drugs(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("catergory_id"),
	                rs.getDouble("price"),
	                rs.getDouble("discount"),
	                rs.getDouble("final_price"),
	                rs.getInt("stock"),
	                rs.getDate("last_updated").toString()
	            ));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	// INCREASE
	public void increaseQuantity(int cart_id) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement(
	            "UPDATE cart SET quantity = quantity + 1 WHERE id=?"
	        );
	        ps.setInt(1, cart_id);
	        ps.executeUpdate();
	    } catch(Exception e) { e.printStackTrace(); }
	}
	
	
	// DECREASE
	public void decreaseQuantity(int cart_id) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        // First check quantity
	        ps = con.prepareStatement("SELECT quantity FROM cart WHERE id=?");
	        ps.setInt(1, cart_id);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            int qty = rs.getInt("quantity");

	            if (qty > 1) {
	                ps = con.prepareStatement(
	                    "UPDATE cart SET quantity = quantity - 1 WHERE id=?"
	                );
	                ps.setInt(1, cart_id);
	                ps.executeUpdate();
	            } else {
	                // remove if quantity = 1
	                ps = con.prepareStatement(
	                    "DELETE FROM cart WHERE id=?"
	                );
	                ps.setInt(1, cart_id);
	                ps.executeUpdate();
	            }
	        }

	    } catch(Exception e) { e.printStackTrace(); }
	}
	
	public void removeCartItem(int cart_id) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("DELETE FROM cart WHERE id=?");
	        ps.setInt(1, cart_id);
	        ps.executeUpdate();
	    } catch(Exception e) { e.printStackTrace(); }
	}
	
	public ArrayList<Drugs> getFilteredDrugs(String category, String drugId, String sort) {

	    con = DatabaseConnection.mydbconnection();
	    ArrayList<Drugs> list = new ArrayList<>();

	    try {
	        String sql = "SELECT * FROM druginfo WHERE 1=1";

	        if (category != null && !category.isEmpty()) {
	            sql += " AND catergory_id=" + category;
	        }

	        if (drugId != null && !drugId.isEmpty()) {
	            sql += " AND id=" + drugId;
	        }

	        if ("asc".equals(sort)) {
	            sql += " ORDER BY name ASC";
	        } else if ("desc".equals(sort)) {
	            sql += " ORDER BY name DESC";
	        }

	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Drugs(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getInt("catergory_id"),
	                rs.getDouble("price"),
	                rs.getDouble("discount"),
	                rs.getDouble("final_price"),
	                rs.getInt("stock"),
	                rs.getDate("last_updated").toString()
	            ));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	// ---------- Doctor Management ----------
	public int addDoctor(String name, String hospital) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("INSERT INTO doctors(name, hospital) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, name);
	        ps.setString(2, hospital);
	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            rs = ps.getGeneratedKeys();
	            if (rs.next()) return rs.getInt(1);
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return 0;
	}

	public ArrayList<Doctor> getAllDoctors() {
	    ArrayList<Doctor> list = new ArrayList<>();
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("SELECT * FROM doctors ORDER BY name");
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            list.add(new Doctor(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("hospital"),
	                rs.getString("created_at")
	            ));
	        }
	    } catch (Exception e) { e.printStackTrace(); }
	    return list;
	}

	public int deleteDoctor(String id) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("DELETE FROM doctors WHERE id=?");
	        ps.setString(1, id);
	        return ps.executeUpdate();
	    } catch (Exception e) { e.printStackTrace(); }
	    return 0;
	}

	public boolean checkDoctorExists(String doctorName, String hospitalName) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement("SELECT * FROM doctors WHERE name=? AND hospital=?");
	        ps.setString(1, doctorName);
	        ps.setString(2, hospitalName);
	        rs = ps.executeQuery();
	        return rs.next();
	    } catch (Exception e) { e.printStackTrace(); }
	    return false;
	}

	// Update addToCart to accept prescription details
	public int addToCart(int user_id, int drug_id, String doctorName, String hospitalName, String prescriptionFile) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        ps = con.prepareStatement(
	            "INSERT INTO cart(user_id, drug_id, quantity, doctor_name, hospital_name, prescription_file) VALUES(?,?,1,?,?,?)"
	        );
	        ps.setInt(1, user_id);
	        ps.setInt(2, drug_id);
	        ps.setString(3, doctorName);
	        ps.setString(4, hospitalName);
	        ps.setString(5, prescriptionFile);
	        return ps.executeUpdate();
	    } catch (Exception e) { e.printStackTrace(); }
	    return 0;
	}

	public void placeOrderWithPrescription(int user_id, String doctorName, String hospitalName, String prescriptionFile) {
	    con = DatabaseConnection.mydbconnection();
	    try {
	        // Calculate total
	        ps = con.prepareStatement(
	            "SELECT SUM(d.final_price * c.quantity) as total FROM cart c JOIN druginfo d ON c.drug_id=d.id WHERE c.user_id=?"
	        );
	        ps.setInt(1, user_id);
	        rs = ps.executeQuery();
	        double total = 0;
	        if (rs.next() && rs.getDouble("total") > 0) {
	            total = rs.getDouble("total");
	        } else {
	            System.out.println("Cart is empty");
	            return;
	        }

	        // Insert order with prescription details
	        ps = con.prepareStatement(
	            "INSERT INTO orders(user_id, total_amount, order_date, status, doctor_name, hospital_name, prescription_file) VALUES(?,?,NOW(),'PLACED',?,?,?)",
	            Statement.RETURN_GENERATED_KEYS
	        );
	        ps.setInt(1, user_id);
	        ps.setDouble(2, total);
	        ps.setString(3, doctorName);
	        ps.setString(4, hospitalName);
	        ps.setString(5, prescriptionFile);
	        ps.executeUpdate();

	        rs = ps.getGeneratedKeys();
	        int order_id = 0;
	        if (rs.next()) order_id = rs.getInt(1);

	        // Insert order items
	        ps = con.prepareStatement(
	            "INSERT INTO order_items(order_id, drug_id, quantity, price) SELECT ?, drug_id, quantity, (quantity * d.final_price) FROM cart c JOIN druginfo d ON c.drug_id=d.id WHERE c.user_id=?"
	        );
	        ps.setInt(1, order_id);
	        ps.setInt(2, user_id);
	        ps.executeUpdate();

	        // Clear cart
	        ps = con.prepareStatement("DELETE FROM cart WHERE user_id=?");
	        ps.setInt(1, user_id);
	        ps.executeUpdate();

	        System.out.println("Order placed with prescription");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

	

