package quotableserver.model;

/**
 * Created by Joshua on 4/28/2016.
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private String type;
    private String flag;
    private int reports;
    private int communityPoints;

    public User(){
        userId = 0;
        reports = 0;
        communityPoints = 0;
        username = "";
        password = "";
        flag = "";
    }

    public User(int userId, String username, String password, String type, String flag, int reports, int communityPoints) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.type = type;
        this.flag = flag;
        this.reports = reports;
        this.communityPoints = communityPoints;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

}
