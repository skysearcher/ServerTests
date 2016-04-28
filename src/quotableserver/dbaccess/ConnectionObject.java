package quotableserver.dbaccess;

import java.io.File;
import java.sql.*;

/**
 * Created by Joshua on 4/27/2016.
 */
public class ConnectionObject {
    private QuoteDAO quoteDAO;
    private QuoteTagDAO quoteTagDAO;
    private TagDAO tagDAO;
    private UserDAO userDAO;
    private Connection connection;

    private static final String DATABASE_DIRECTORY = "database";
    private static final String DATABASE_FILE = "Project1.sqlite";
    private static final String DATABASE_URL = "jdbc:sqlite:" + DATABASE_DIRECTORY + File.separator + DATABASE_FILE;

    public ConnectionObject(){
        quoteDAO = new QuoteDAO();
        quoteTagDAO = new QuoteTagDAO();
        tagDAO = new TagDAO();
        userDAO = new UserDAO();

        try {
            String driver = "org.sqlite.JDBC";
            File f = new File(driver);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void startConnection(){
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL);
                connection.setAutoCommit(false);
                if (connection == null) {
                    System.out.println("DIE");
                } else {
                    connection.setAutoCommit(false);
                    System.out.println("real");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public QuoteDAO getQuoteDAO() {
        return quoteDAO;
    }

    public QuoteTagDAO getQuoteTagDAO() {
        return quoteTagDAO;
    }

    public TagDAO getTagDAO() {
        return tagDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
