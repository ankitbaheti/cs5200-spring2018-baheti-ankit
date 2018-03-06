package model;

import interfaceDao.RoleDAOInterface;

import java.sql.*;
import java.util.Collection;
import java.util.Iterator;

public class RoleDAO extends BaseDAO implements RoleDAOInterface{

    private static RoleDAO instance = null;

    private RoleDAO(){
    }

    public static RoleDAO getInstance(){
        if(instance == null){
            instance = new RoleDAO();
        }
        return instance;
    }

    @Override
    public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into WebsiteRole(Role, Website, Developer) values (?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, roleId);
            pstm.setInt(2, websiteId);
            pstm.setInt(3, developerId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assignPageRole(int developerId, int pageId, int roleId) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into PageRole(Role, Page, Developer) values (?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, roleId);
            pstm.setInt(2, pageId);
            pstm.setInt(3, developerId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from WebsiteRole where Developer = ? and Website = ? and Role = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            pstm.setInt(2, websiteId);
            pstm.setInt(3, roleId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePageRole(int developerId, int pageId, int roleId) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from PageRole where Developer = ? and Page = ? and Role = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            pstm.setInt(2, pageId);
            pstm.setInt(3, roleId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRoleIdFromName(String roleName){
        int roleId = 0;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select id from Role where roleName = ? ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, roleName);
            rs = pstm.executeQuery();
            while (rs.next()){
                roleId = rs.getInt("id");
            }
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return roleId;
    }

    private int getRoleId(int pageId, int developerId){
        int result = -1;
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select role from PageRole where developer = ? and pageId = ?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            pstm.setInt(2, pageId);
            rs = pstm.executeQuery();
            while(rs.next())
                result = rs.getInt("role");
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void swapRole(String developer1Name, String developer2Name, String websiteName, String pageName){
        DeveloperDAO developerDAO = DeveloperDAO.getInstance();
        WebsiteDAO websiteDAO = WebsiteDAO.getInstance();
        PageDAO pageDAO = PageDAO.getInstance();

        Developer developer1 = developerDAO.findDeveloperByUsername(developer1Name);
        Developer developer2 = developerDAO.findDeveloperByUsername(developer2Name);

        int websiteId = websiteDAO.findWebsiteIdByName(websiteName);
        int pageId = -1;

        Collection<Page> pagesForWebsite = pageDAO.findPagesForWebsite(websiteId);
        Iterator<Page> itr = pagesForWebsite.iterator();
        while (itr.hasNext()) {
            Page p = itr.next();
            if(p.getTitle() == pageName)
                pageId = p.getId();
        }

        int roleId1 = getRoleId(pageId, developer1.getId());
        int roleId2 = getRoleId(pageId, developer2.getId());

        deletePageRole(developer1.getId(), pageId, roleId1);
        assignPageRole(developer1.getId(), pageId, roleId2);

        deletePageRole(developer2.getId(), pageId, roleId2);
        assignPageRole(developer2.getId(), pageId, roleId1);
    }
}
