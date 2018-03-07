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

    public void swapRole(String developer1Name, String developer2Name, String websiteName, String pageName){
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = " update PageRole set Role = case when Page = (select id from Page where Website = (select " +
                    "id from Website where name = ?) and title = ?)and Developer = (select id from Developer where " +
                    "Person = (select id from Person where username = ?))then (select Role from (select * from pagerole)" +
                    " as copy_pagerole where Page = " +
                    "(select id from Page where Website = (select id from Website where name = ?) and title = ?)and " +
                    "Developer = (select id from Developer where Person = (select id from Person where username = ?)))" +
                    "when Page = (select id from Page where Website = (select id from Website where name = ?) and " +
                    "title = ?)and Developer = (select id from Developer where Person = (select id from Person where " +
                    "username = ?))then(select Role from (select * from pagerole) as copy_pr where Page = " +
                    "(select id from Page where Website = " +
                    "(select id from Website where name = ?) and title = ?)and Developer = (select id from Developer " +
                    "where Person = (select id from Person where username = ?)))else Role end ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, websiteName);
            pstm.setString(2, pageName);
            pstm.setString(3, developer2Name);
            pstm.setString(4,websiteName);
            pstm.setString(5,pageName);
            pstm.setString(6,developer1Name);
            pstm.setString(7,websiteName);
            pstm.setString(8,pageName);
            pstm.setString(9,developer1Name);
            pstm.setString(10,websiteName);
            pstm.setString(11,pageName);
            pstm.setString(12,developer2Name);
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}