package quotableserver.dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Joshua on 4/27/2016.
 */
public class UserDAO {
    private Connection connection;

    public boolean checkTable(){
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        query = "SELECT name FROM sqlite_master WHERE type='table' AND name='players'";
        try {
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void createTable(){
        String query;
        PreparedStatement stmt;

        query = "CREATE TABLE users " +
                "(UserId int PRIMARY KEY," +
                " Username  varchar(32)  NOT NULL, " +
                " Password  varchar(32)  NOT NULL, " +
                " Flag  varchar(32), " +
                " Reports   int, " +
                " CommunityPoints int, ";

        try {
            stmt = connection.prepareStatement(query);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(){

    }
}
