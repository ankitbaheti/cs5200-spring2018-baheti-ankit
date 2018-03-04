package jdbc.model;

public class PagePriviledge {

    private String pageName;
    private String developerName;
    private String priviledgeName;
    private int pageId;
    private int developerId;
    private int priviledgeId;
    private Page page;
    private Developer developer;

    public PagePriviledge() {
    }

    public PagePriviledge(String pageName, String developerName, String priviledgeName) {
        this.pageName = pageName;
        this.developerName = developerName;
        this.priviledgeName = priviledgeName;
    }

    public PagePriviledge(int pageId, int developerId, int priviledgeId) {
        this.pageId = pageId;
        this.developerId = developerId;
        this.priviledgeId = priviledgeId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
