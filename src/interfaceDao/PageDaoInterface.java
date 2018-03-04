package interfaceDao;

import model.Page;
import java.util.Collection;

public interface PageDaoInterface {

    int createPageForWebsite(int websiteId, Page page);

    Collection<Page> findAllPages();

    Page findPageById(int pageId);

    Collection<Page> findPagesForWebsite(int websiteId);

    int updatePage(int pageId, Page page);

    int deletePage(int pageId);
}
