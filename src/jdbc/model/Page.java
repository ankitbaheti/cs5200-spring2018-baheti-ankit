package jdbc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Page {

    private int id;
    private String title;
    private String description;
    private Date created;
    private Date updated;
    private int views;
    private Website website;
    private List<Widget> widget = new ArrayList<>();
    private List<PageRole> pageRole = new ArrayList<>();
    private List<PagePriviledge> pagePriviledge = new ArrayList<>();

    public Page() {
    }

    public Page(int id, String title, String description, Date created, Date updated, int views, Website website,
                List<Widget> widget, List<PageRole> pageRole, List<PagePriviledge> pagePriviledge) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.views = views;
        this.website = website;
        this.widget = widget;
        this.pageRole = pageRole;
        this.pagePriviledge = pagePriviledge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public List<Widget> getWidget() {
        return widget;
    }

    public void setWidget(List<Widget> widget) {
        this.widget = widget;
    }

    public List<PageRole> getPageRole() {
        return pageRole;
    }

    public void setPageRole(List<PageRole> pageRole) {
        this.pageRole = pageRole;
    }

    public List<PagePriviledge> getPagePriviledge() {
        return pagePriviledge;
    }

    public void setPagePriviledge(List<PagePriviledge> pagePriviledge) {
        this.pagePriviledge = pagePriviledge;
    }
}
