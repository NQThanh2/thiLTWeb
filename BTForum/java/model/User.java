package model;
import java.util.Date;

public class User {
    private String userName;
    private String password;
    private String email;
    private Date joinDate;

    public User() {}
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.joinDate = new Date();
    }

    public boolean verify(String u, String p) {
        return this.userName.equals(u) && this.password.equals(p);
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public Date getJoinDate() { return joinDate; }
}