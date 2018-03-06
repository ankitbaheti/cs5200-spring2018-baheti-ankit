package model;

import interfaceDao.DeveloperDAOInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDAO extends BaseDAO implements DeveloperDAOInterface {

    private static DeveloperDAO instance = null;

    private DeveloperDAO(){
    }

    public static DeveloperDAO getInstance(){
        if(instance == null) {
            instance = new DeveloperDAO();
        }
        return instance;
    }

    @Override
    public int createDeveloper(Developer developer) {

        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            createPerson(developer.getPerson());
            String sql = "insert into developer(id, developerKey, person) values (?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developer.getId());
            pstm.setString(2, developer.getDeveloperKey());
            pstm.setInt(3, developer.getPerson().getId());
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void createPerson(Person person){
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into Person(id, firstName, lastName, username, password, email, dob) values (?,?,?" +
                    ",?,?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, person.getId());
            pstm.setString(2, person.getFirstName());
            pstm.setString(3,person.getLastName());
            pstm.setString(4, person.getUsername());
            pstm.setString(5, person.getPassword());
            pstm.setString(6, person.getEmail());
            pstm.setDate(7, person.getDob());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Developer> findAllDevelopers() {

        List<Developer> developerList = new ArrayList<>();
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select p.*, d.id, d.developerKey from person p, developer d where p.id = d.person";
            PreparedStatement pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            developerList = getDevelopers(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return developerList;
    }

    private List<Developer> getDevelopers(ResultSet rs){
        List<Developer> developerList = new ArrayList<>();
        try {
            while(rs.next()){
                Developer dev = new Developer();
                dev.getPerson().setId(rs.getInt("id"));
                dev.setFirstName(rs.getString("firstName"));
                dev.setLastName(rs.getString("lastName"));
                dev.setUsername(rs.getString("username"));
                dev.setPassword(rs.getString("password"));
                dev.setEmail(rs.getString("email"));
                dev.setDob(rs.getDate("dob"));
                dev.setId(rs.getInt(8));
                dev.setDeveloperKey(rs.getString("developerKey"));
                developerList.add(dev);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerList;
    }

    @Override
    public Developer findDeveloperById(int developerId) {

        ResultSet rs = null;
        List<Developer> developerList = new ArrayList<>();
        Developer dev = new Developer();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select p.*, d.id, d.developerKey from person p, developer d where p.id = d.person and " +
                    "d.id = ? ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            rs = pstm.executeQuery();
            developerList = getDevelopers(rs);
            if(!developerList.isEmpty())
                dev = developerList.get(0);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dev;
    }

    @Override
    public Developer findDeveloperByUsername(String username) {

        Developer dev = new Developer();
        List<Developer> developerList = new ArrayList<>();
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select p.*, d.id, d.developerKey from person p, developer d where d.person = p.id " +
                    "and p.username = ? ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            developerList = getDevelopers(rs);
            if(!developerList.isEmpty())
                dev = developerList.get(0);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dev;
    }

    @Override
    public Developer findDeveloperByCredentials(String username, String password) {

        ResultSet rs = null;
        List<Developer> developerList = new ArrayList<>();
        Developer dev = new Developer();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select p.*, d.id, d.developerKey from developer d, person p where p.id = d.person and" +
                    "p.username = ? and p.password = ? ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            developerList = getDevelopers(rs);
            if(!developerList.isEmpty())
                dev = developerList.get(0);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dev;
    }

    @Override
    public int updateDeveloper(int developerId, Developer developer) {

        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update developer set person = ?, developerKey = ? where id = ? ;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developer.getPerson().getId());
            pstm.setString(2, developer.getDeveloperKey());
            pstm.setInt(3, developerId);
            updatePerson(developerId, developer.getPerson());
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int updatePerson(int developerId, Person person){

        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update person set firstName = ?, lastName = ?, username = ?, password = ?, email = ?, " +
                    "dob = ? where id = (select person from developer where id = ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, person.getFirstName());
            pstm.setString(2, person.getLastName());
            pstm.setString(3, person.getUsername());
            pstm.setString(4, person.getPassword());
            pstm.setString(5, person.getEmail());
            pstm.setDate(6, person.getDob());
            pstm.setInt(7, developerId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteDeveloper(int developerId) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from developer where id = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            deletePerson(developerId);
            pstm.setInt(1, developerId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int deletePerson(int developerId){
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from person where id = (select person from developer where id = ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, developerId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
