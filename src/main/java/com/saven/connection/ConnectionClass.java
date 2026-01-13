package com.saven.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    // ✅ SINGLE entry point for DB connection
    public static Connection getConnection() {

        Connection connection = null;

        try {
            // ✅ REQUIRED for MySQL 8+
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ===============================
            // ✅ RAILWAY ENVIRONMENT VARIABLES
            // ===============================
            String dbUrl  = System.getenv("mysql://root:ammfpaqduCybjRTacpvwjiZqkqGrhmgH@mysql.railway.internal:3306/railway");       // FULL JDBC URL
            String dbUser = System.getenv("root");      // username
            String dbPass = System.getenv("ammfpaqduCybjRTacpvwjiZqkqGrhmgH");  // password

            // ❗ DEBUG (remove later if you want)
            System.out.println("DB URL: " + dbUrl);
            System.out.println("DB USER: " + dbUser);

            // ✅ CONNECT
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver not found");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
        }

        return connection;
    }
    public static void main(String[] args) {
        Connection c = ConnectionClass.getConnection();
        System.out.println(c != null ? "✅ Connected" : "❌ Failed");
    }

}
