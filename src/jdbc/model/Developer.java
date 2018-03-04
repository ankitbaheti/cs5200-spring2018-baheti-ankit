package jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Person{

    private int id;
    private String developerKey;
    private Person person;
    private List<Website> websiteList = new ArrayList<>();
    private List<WebsiteRole> websiteRoleList = new ArrayList<>();
    private List<WebsitePriviledge> websitePriviledgeList = new ArrayList<>();
    private List<PageRole> pageRoleList = new ArrayList<>();
    private List<PagePriviledge> pagePriviledgeList = new ArrayList<>();

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

    public List<Website> getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(List<Website> websiteList) {
        this.websiteList = websiteList;
    }

    public List<WebsiteRole> getWebsiteRoleList() {
        return websiteRoleList;
    }

    public void setWebsiteRoleList(List<WebsiteRole> websiteRoleList) {
        this.websiteRoleList = websiteRoleList;
    }

    public List<WebsitePriviledge> getWebsitePriviledgeList() {
        return websitePriviledgeList;
    }

    public void setWebsitePriviledgeList(List<WebsitePriviledge> websitePriviledgeList) {
        this.websitePriviledgeList = websitePriviledgeList;
    }

    public List<PageRole> getPageRoleList() {
        return pageRoleList;
    }

    public void setPageRoleList(List<PageRole> pageRoleList) {
        this.pageRoleList = pageRoleList;
    }

    public List<PagePriviledge> getPagePriviledgeList() {
        return pagePriviledgeList;
    }

    public void setPagePriviledgeList(List<PagePriviledge> pagePriviledgeList) {
        this.pagePriviledgeList = pagePriviledgeList;
    }
}
