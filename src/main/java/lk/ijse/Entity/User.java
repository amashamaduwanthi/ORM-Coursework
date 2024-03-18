package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user")
public class User {
   @Id
//    @GeneratedValue(generator = "Admin-Id-Generator")
//    @GenericGenerator(name = "Admin-Id-Generator", strategy = "lk.ijse.util.AdminIdGenerator")
    private String adminId;
    private String userName;
    private String password;
    private String confirmPassword;

    public User() {
    }

    public User(String adminId, String userName, String password, String confirmPassword) {
        this.adminId = adminId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
