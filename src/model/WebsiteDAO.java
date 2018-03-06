package model;

import interfaceDao.WebsiteDAOInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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
        int result = -1;
        RoleDAO rDao = RoleDAO.getInstance();
        DeveloperDAO dDao = DeveloperDAO.getInstance();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into website(id, name, description, created, updated, visits, developer) values (?," +
                    "?,?,?,?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, website.getId());
            pstm.setString(2, website.getName());
            pstm.setString(3, website.getDescription());
            pstm.setDate(4, website.getCreated());
            pstm.setDate(5, website.getUpdated());
            pstm.setInt(6, website.getVisit());
            pstm.setInt(7, developerId);
            result = pstm.executeUpdate();
            List<WebsiteRole> websiteRoles = website.getWebsiteRoles();
            Iterator<WebsiteRole> itr = websiteRoles.iterator();
            while(itr.hasNext()){
                WebsiteRole websiteRole = itr.next();
                int devID = dDao.findDeveloperByUsername(websiteRole.getDeveloperName()).getId();
                int roleId = rDao.getRoleIdFromName(websiteRole.getRoleName());
                rDao.assignWebsiteRole(devID, website.getId(), roleId);
            }
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Website> findAllWebsites() {

        ResultSet rs;
        List<Website> websiteList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "Select * from website;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            websiteList = getWebsitefromRs(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return websiteList;
    }

    private List<Website> getWebsitefromRs(ResultSet rs){

        List<Website> websiteList = new ArrayList<>();
        try {
            while (rs.next()){
                Website website = new Website();
                website.setId(rs.getInt("id"));
                website.setName(rs.getString("name"));
                website.setDescription(rs.getString("description"));
                website.setCreated(rs.getDate("created"));
                website.setUpdated(rs.getDate("updated"));
                website.setVisit(rs.getInt("visits"));
                website.getDeveloper().setId(rs.getInt("developer"));
                websiteList.add(website);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return websiteList;
    }

    @Override
    public Collection<Website> findWebsitesForDeveloper(int developerId) {
        List<Website> websiteList = new ArrayList<>();
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from website where developer = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            rs = pstm.executeQuery();
            websiteList = getWebsitefromRs(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return websiteList;
    }

    @Override
    public Website findWebsiteById(int websiteId) {
         ResultSet rs;
         Website website = new Website();
         List<Website> websiteList;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from website where id = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, websiteId);
            rs = pstm.executeQuery();
            websiteList = getWebsitefromRs(rs);
            while(!websiteList.isEmpty())
                website = websiteList.get(0);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return website;
    }

    @Override
    public int updateWebsite(int websiteId, Website website) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update website set name = ?, description = ?, created = ?, updated = ?, visits = ?, " +
                    "developer= ? where id= ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, website.getName());
            pstm.setString(2, website.getDescription());
            pstm.setDate(3, website.getCreated());
            pstm.setDate(4, website.getUpdated());
            pstm.setInt(5, website.getVisit());
            pstm.setInt(6, website.getDeveloper().getId());
            pstm.setInt(7, websiteId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteWebsite(int websiteId) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from website where id= ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, websiteId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
