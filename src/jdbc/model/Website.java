package jdbc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Website {

    private int id;
    private String name;
    private String description;
    private Date created;
    private Date updated;
    private int visit;
    private Developer developer;
    private List<Page> pages = new ArrayList<>();
    private List<WebsiteRole> websiteRoles = new ArrayList<>();
    private List<WebsitePriviledge> websitePriviledge = new ArrayList<>();

    public Website() {
    }

    public Website(int id, String name, String description, Date created, Date updated, int visit, Developer developer,
                   List<Page> pages, List<WebsiteRole> websiteRoles, List<WebsitePriviledge> websitePriviledge) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.visit = visit;
        this.developer = developer;
        this.pages = pages;
        this.websiteRoles = websiteRoles;
        this.websitePriviledge = websitePriviledge;
    }

    public int getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<WebsiteRole> getWebsiteRoles() {
        return websiteRoles;
    }

    public void setWebsiteRoles(List<WebsiteRole> websiteRoles) {
        this.websiteRoles = websiteRoles;
    }

    public List<WebsitePriviledge> getWebsitePriviledge() {
        return websitePriviledge;
    }

    public void setWebsitePriviledge(List<WebsitePriviledge> websitePriviledge) {
        this.websitePriviledge = websitePriviledge;
    }
}
