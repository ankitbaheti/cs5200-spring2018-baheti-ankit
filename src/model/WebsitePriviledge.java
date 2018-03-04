package model;

public class WebsitePriviledge {

    private String websiteName;
    private String developerName;
    private String priviledgeName;
    private int websiteId;
    private int developerId;
    private int priviledgeId;
    private Developer developer;
    private Website website;

    public WebsitePriviledge() {
    }

    public WebsitePriviledge(String websiteName, String developerName, String priviledgeName) {
        this.websiteName = websiteName;
        this.developerName = developerName;
        this.priviledgeName = priviledgeName;
    }

    public WebsitePriviledge(int websiteId, int developerId, int priviledgeId) {
        this.websiteId = websiteId;
        this.developerId = developerId;
        this.priviledgeId = priviledgeId;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getPriviledgeName() {
        return priviledgeName;
    }

    public void setPriviledgeName(String priviledgeName) {
        this.priviledgeName = priviledgeName;
    }

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public int getPriviledgeId() {
        return priviledgeId;
    }

    public void setPriviledgeId(int priviledgeId) {
        this.priviledgeId = priviledgeId;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }
}
