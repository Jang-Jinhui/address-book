package sample.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sample.domain.User;


public class UserDao extends BaseDao {

    // @formatter:off
    private static String saveQuery = new StringBuilder()
            .append("CREATE User ( \n")
            .append("    name, \n")
            .append("    zipcode, \n")
            .append("    address, \n")
            .append("    email \n")
            .append(") \n")
            .append("VALUES ( \n")
            .append("    ?, \n")
            .append("    ?, \n")
            .append("    ?, \n")
            .append("    ? \n")
            .append(") \n")
        .toString();
    // @formatter:on

    public void save(User user) {
        try (Connection conn = getConnection()) {
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(saveQuery);
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getZipcode());
                pstmt.setString(3, user.getAddress());
                pstmt.setString(4, user.getEmail());
                pstmt.execute();
            }
            finally {
                closeQuietly(null, pstmt);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
