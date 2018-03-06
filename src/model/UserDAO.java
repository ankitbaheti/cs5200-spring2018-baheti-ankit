package model;

import interfaceDao.UserDAOInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends BaseDAO implements UserDAOInterface{

    private static UserDAO instance = null;

    private UserDAO(){
    }

    public static UserDAO getInstance() {
        if(instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public int createUser(User user) {

        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            createPerson(user.getPerson());
            String sql = "insert into user(id, userAgreement, userKey, Person) values (?,?,?,?);";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getId());
            pstm.setBoolean(2, user.getUserAgreement());
            pstm.setString(3, user.getUserKey());
            pstm.setInt(4, user.getPerson().getId());
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
}
