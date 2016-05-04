package quotableserver.dbaccess;

import java.sql.Connection;

/**
 * Created by Joshua on 4/27/2016.
 */
public class QuoteDAO {
    private Connection connection;


    public void setConnection(Connection con){
        connection = con;
    }
    public boolean checkTable(){
        return true;
    }
    public void createTable(){

    }
    public void addQuote(){

    }

}
