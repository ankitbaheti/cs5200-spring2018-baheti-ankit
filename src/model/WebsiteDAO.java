package model;

import interfaceDao.WebsiteDAOInterface;

import java.util.Collection;

public class WebsiteDAO extends BaseDAO implements WebsiteDAOInterface {

    private static WebsiteDAO instance = null;

    private WebsiteDAO(){
    }

    public static WebsiteDAO getInstance(){
        if(instance == null){
            instance = new WebsiteDAO();
        }
        return instance;
    }

    @Override
    public int createWebsiteForDeveloper(int developerId, Website website) {
        return 0;
    }

    @Override
    public Collection<Website> findAllWebsites() {
        return null;
    }

    @Override
    public Collection<Website> findWebsitesForDeveloper(int developerId) {
        return null;
    }

    @Override
    public Website findWebsiteById(int websiteId) {
        return null;
    }

    @Override
    public int updateWebsite(int websiteId, Website website) {
        return 0;
    }

    @Override
    public int deleteWebsite(int websiteId) {
        return 0;
    }
}
