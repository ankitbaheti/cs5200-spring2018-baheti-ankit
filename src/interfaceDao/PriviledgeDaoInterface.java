package interfaceDao;

public interface PriviledgeDaoInterface {

    void assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId);

    void assignPagePriviledge(int developerId, int pageId, int priviledgeId);

    void deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId);

    void deletePagePriviledge(int developerId, int pageId, int priviledgeId);
}
