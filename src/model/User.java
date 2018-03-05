package model;

public class User extends Person{

    private int id;
    private String userKey;
    private int userAgreement;
    private Person person;

    public User() {
    }

    public User(int id, String userKey, int userAgreement, Person person) {
        this.id = id;
        this.userKey = userKey;
        this.userAgreement = userAgreement;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public int getUserAgreement() {
        return userAgreement;
    }

    public void setUserAgreement(int userAgreement) {
        this.userAgreement = userAgreement;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
