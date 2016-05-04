package quotableserver.dbaccess;

import quotableserver.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 4/27/2016.
 */
public class UserDAO {
    private Connection connection;


    public void setConnection(Connection con){
        connection = con;
    }

    public boolean checkTable(){
        String query;
        PreparedStatement stmt;
        ResultSet rs;
        query = "SELECT name FROM sqlite_master WHERE type='table' AND name='users'";
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
                " Type varchar(64) NOT NULL, " +
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
    public void addUser(User user){
        PreparedStatement stmt;
        ResultSet rs = null;
        try {
            String query = "insert into users (Username, Password, Type, Flag, Reports, CommunityPoints) values (?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, "");
            stmt.setInt(4, 0);
            stmt.setInt(5, 0);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        PreparedStatement stmt;
        ResultSet rs;

        try {
            String query = "select * from users";
            stmt = connection.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void updateUser(User user){
        PreparedStatement stmt;

        try {
            String query = "update users set Username = ?, Password = ?, Flag = ?, Reports = ?, CommunityPoints = ? where UserId = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFlag());
            stmt.setInt(4, user.getReports());
            stmt.setInt(5, user.getCommunityPoints());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
