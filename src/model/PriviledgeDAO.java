package model;

import interfaceDao.PriviledgeDAOInterface;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriviledgeDAO extends BaseDAO implements PriviledgeDAOInterface{

    private static PriviledgeDAO instance = null;

    private PriviledgeDAO(){
    }

    public static PriviledgeDAO getInstance(){
        if(instance == null){
            instance = new PriviledgeDAO();
        }
        return instance;
    }

    @Override
    public void assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into WebsitePriviledge(Priviledge, Website, Developer) values (?,?,?);";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, priviledgeId);
            pstm.setInt(2, websiteId);
            pstm.setInt(3,developerId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into PagePriviledge(Priviledge, Page, Developer) values (?,?,?);";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, priviledgeId);
            pstm.setInt(2, pageId);
            pstm.setInt(3,developerId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from WebsitePriviledge where developer = ? and website = ? and priviledge = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            pstm.setInt(2, websiteId);
            pstm.setInt(3,priviledgeId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePagePriviledge(int developerId, int pageId, int priviledgeId) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from PagePriviledge where developer = ? and page = ? and priviledge = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            pstm.setInt(2, pageId);
            pstm.setInt(3,priviledgeId);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int getPriviledgeIdFromName(String priviledgeName){
        ResultSet rs = null;
        int priviledgeId = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select id from Priviledge where priviledgeName = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, priviledgeName);
            rs = pstm.executeQuery();
            while (rs.next()){
                priviledgeId = rs.getInt("id");
            }
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return priviledgeId;
    }
}
