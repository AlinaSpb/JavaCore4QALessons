package lesson8;

import java.sql.*;

public class SQLiteManager {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:test.db");
    }

    public void executeUpdate(Statement stmt, String sql) throws SQLException {
        stmt.executeUpdate(sql);
        stmt.close();
    }

    public ResultSet executeQuery(Statement stmt, String sql) throws SQLException {
        ResultSet resultSet =  stmt.executeQuery(sql);
        return resultSet;
    }
}
