package jdbc.model;

public class User {

    private int id;
    private String userKey;
    private boolean userAgreement;
    private Person person;

    public User() {
    }

    public User(int id, String userKey, boolean userAgreement, Person person) {
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

    public boolean isUserAgreement() {
        return userAgreement;
    }

    public void setUserAgreement(boolean userAgreement) {
        this.userAgreement = userAgreement;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
