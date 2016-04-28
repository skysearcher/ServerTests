package quotableserver.model;

/**
 * Created by Joshua on 4/28/2016.
 */
public class User {
    private int userId;
    private int reports;
    private int communityPoints;
    private String username;
    private String password;
    private String flag;

    public User(){
        userId = 0;
        reports = 0;
        communityPoints = 0;
        username = "";
        password = "";
        flag = "";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    public int getCommunityPoints() {
        return communityPoints;
    }

    public void setCommunityPoints(int communityPoints) {
        this.communityPoints = communityPoints;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
