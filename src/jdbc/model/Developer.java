package jdbc.model;

public class Developer {

    private int id;
    private String developerKey;
    private Person person;

    public Developer(int id, String developerKey, Person person) {
        this.id = id;
        this.developerKey = developerKey;
        this.person = person;
    }

    public Developer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeveloperKey() {
        return developerKey;
    }

    public void setDeveloperKey(String developerKey) {
        this.developerKey = developerKey;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
