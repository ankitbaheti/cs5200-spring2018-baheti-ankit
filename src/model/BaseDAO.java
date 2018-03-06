package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseDAO {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/hw3_baheti_ankit_spring2018?useSSL=false";
    final String USERNAME = "root";
    final String PASSWORD = "root";
}
