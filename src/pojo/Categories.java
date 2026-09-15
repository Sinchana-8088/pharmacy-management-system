package pojo;

public class Categories {

    Integer id;
	String name="";
	
	public Categories(String name) {
        this.name = name;
    }
    public Categories(int id, String name) {
    	super();
    	this.id=id;
        this.name = name;
    }
    public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}