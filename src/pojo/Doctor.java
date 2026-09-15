package pojo;

public class Doctor {
    private int id;
    private String name;
    private String hospital;
    private String createdAt;

    public Doctor() {}

    public Doctor(int id, String name, String hospital, String createdAt) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getHospital() { return hospital; }
    public void setHospital(String hospital) { this.hospital = hospital; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}

