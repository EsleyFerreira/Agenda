package br.com.esley.agenda.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String USERNAME = "admin3050";
    private static final String PASSWORD = "3050";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = createConnectionToMySQL()) {
            if (conn != null) {
                System.out.println("Connection success!");
            } else {
                System.out.println("Connection error!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}