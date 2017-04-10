package sample.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public abstract class BaseDao {

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection("", "", "");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(Connection conn) {
        try {
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(Connection conn, PreparedStatement stmt) {
        try {
            if (Objects.nonNull(conn)) {
                conn.close();
            }
            if (Objects.nonNull(stmt)) {
                stmt.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected void closeQuietly(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (Objects.nonNull(conn)) {
                conn.close();
            }
            if (Objects.nonNull(stmt)) {
                stmt.close();
            }
            if (Objects.nonNull(rs)) {
                rs.close();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
