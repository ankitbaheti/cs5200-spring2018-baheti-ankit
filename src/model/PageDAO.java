package model;

import interfaceDao.PageDAOInterface;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PageDAO extends BaseDAO implements PageDAOInterface{

    private static PageDAO instance = null;

    private PageDAO(){
    }

    public static PageDAO getInstance(){
        if(instance == null){
            instance = new PageDAO();
        }
        return instance;
    }

    @Override
    public int createPageForWebsite(int websiteId, Page page) {
        int result = -1;
        RoleDAO rDao = RoleDAO.getInstance();
        DeveloperDAO dDao = DeveloperDAO.getInstance();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into page(id, title, description, created, updated, views, website) values (?,?,?," +
                    "?,?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, page.getId());
            pstm.setString(2, page.getTitle());
            pstm.setString(3, page.getDescription());
            pstm.setDate(4, page.getCreated());
            pstm.setDate(5, page.getUpdated());
            pstm.setInt(6, page.getViews());
            pstm.setInt(7, page.getWebsite().getId());
            result = pstm.executeUpdate();
            List<PageRole> pageRoleList = page.getPageRole();
            Iterator<PageRole> itr = pageRoleList.iterator();
            while(itr.hasNext()){
                PageRole pageRole = itr.next();
                int devId = dDao.findDeveloperByUsername(pageRole.getDeveloperName()).getId();
                int roleId = rDao.getRoleIdFromName(pageRole.getRoleName());
                rDao.assignPageRole(devId, page.getId(), roleId);
            }
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Page> findAllPages() {

        ResultSet rs;
        List<Page> pageList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from page;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            pageList = getPageFromRS(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return pageList;
    }

    private List<Page> getPageFromRS(ResultSet rs){
        List<Page> pageList = new ArrayList<>();
        try {
            while(rs.next()){
                Page page = new Page();
                page.setId(rs.getInt("id"));
                page.setTitle(rs.getString("title"));
                page.setDescription(rs.getString("description"));
                page.setCreated(rs.getDate("created"));
                page.setUpdated(rs.getDate("updated"));
                page.setViews(rs.getInt("views"));
                pageList.add(page);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageList;
    }

    @Override
    public Page findPageById(int pageId) {

        ResultSet rs;
        Page page = new Page();
        List<Page> pageList;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from page where id = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pageId);
            rs = pstm.executeQuery();
            pageList = getPageFromRS(rs);
            while(!pageList.isEmpty())
                page = pageList.get(0);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public Collection<Page> findPagesForWebsite(int websiteId) {
        List<Page> pageList = new ArrayList<>();
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from page where website = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, websiteId);
            rs = pstm.executeQuery();
            pageList = getPageFromRS(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return pageList;
    }

    @Override
    public int updatePage(int pageId, Page page) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update page set title = ?, description = ?, created = ?, updated = ?, views = ?, " +
                    "website = ? where id = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, page.getTitle());
            pstm.setString(2, page.getDescription());
            pstm.setDate(3, page.getCreated());
            pstm.setDate(4, page.getUpdated());
            pstm.setInt(5, page.getViews());
            pstm.setInt(6, page.getWebsite().getId());
            pstm.setInt(7, pageId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deletePage(int pageId) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from page where id =?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pageId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int append(Website website, String s){
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update page set title = concat(?,?) where website = (select id from website where name = ?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, s);
            pstm.setString(2, website.getName());
            pstm.setString(3, website.getName());
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Page findPageByName(String pageName){
        Page page = new Page();
        ResultSet rs;
        List<Page> pageList;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from Page where title = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, pageName);
            rs = pstm.executeQuery();
            pageList = getPageFromRS(rs);
            while(!pageList.isEmpty()){
                page = pageList.get(0);
            }
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

    public void removeLastUpdatedPage(String websiteName){
        WebsiteDAO websiteDAO = WebsiteDAO.getInstance();
        int websiteId = websiteDAO.findWebsiteIdByName(websiteName);
        int pageId = -1;
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select id from page where website = ? order by updated desc limit 1;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, websiteId);
            rs = pstm.executeQuery();
            while (rs.next())
                pageId = rs.getInt("id");
            deletePage(pageId);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
