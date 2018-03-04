package model;

public class PageRole {

    private String pageName;
    private String developerName;
    private String roleName;
    private int pageId;
    private int developerId;
    private int roleId;
    private Page page;
    private Developer developer;

    public PageRole() {
    }

    public PageRole(String pageName, String developerName, String roleName) {
        this.pageName = pageName;
        this.developerName = developerName;
        this.roleName = roleName;
    }

    public PageRole(int pageId, int developerId, int roleId) {
        this.pageId = pageId;
        this.developerId = developerId;
        this.roleId = roleId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
