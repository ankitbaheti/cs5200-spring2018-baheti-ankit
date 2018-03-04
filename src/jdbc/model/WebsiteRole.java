package jdbc.model;

public class WebsiteRole {

    private String websiteName;
    private String developerName;
    private String roleName;
    private int websiteId;
    private int developeId;
    private int roleId;

    public WebsiteRole() {
    }

    public WebsiteRole(String websiteName, String developerName, String roleName) {
        this.websiteName = websiteName;
        this.developerName = developerName;
        this.roleName = roleName;
    }

    public WebsiteRole(int websiteId, int developeId, int roleId) {
        this.websiteId = websiteId;
        this.developeId = developeId;
        this.roleId = roleId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public int getDevelopeId() {
        return developeId;
    }

    public void setDevelopeId(int developeId) {
        this.developeId = developeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
