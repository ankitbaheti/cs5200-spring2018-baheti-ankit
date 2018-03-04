package interfaceDao;

import model.Website;
import java.util.Collection;

public interface WebsiteDaoInterface {

    int createWebsiteForDeveloper(int developerId, Website website);

    Collection<Website> findAllWebsites();

    Collection<Website> findWebsitesForDeveloper(int developerId);

    Website findWebsiteById(int websiteId);

    int updateWebsite(int websiteId, Website website);

    int deleteWebsite(int websiteId);
}
