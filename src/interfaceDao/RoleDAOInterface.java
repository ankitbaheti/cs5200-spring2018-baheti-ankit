package interfaceDao;

public interface RoleDAOInterface {

    void assignWebsiteRole(int developerId, int websiteId, int roleId);

    void assignPageRole(int developerId, int pageId, int roleId);

    void deleteWebsiteRole(int developerId, int websiteId, int roleId);

    void deletePageRole(int developerId, int pageId, int roleId);
}
