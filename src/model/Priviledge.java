package model;

public class Priviledge {

    private  int id;
    private String priviledgeName;

    public Priviledge() {
    }

    public Priviledge(int id, String priviledgeName) {
        this.id = id;
        this.priviledgeName = priviledgeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriviledgeName() {
        return priviledgeName;
    }

    public void setPriviledgeName(String priviledgeName) {
        this.priviledgeName = priviledgeName;
    }
}
