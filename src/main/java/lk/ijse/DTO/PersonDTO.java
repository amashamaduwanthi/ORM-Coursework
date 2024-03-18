package lk.ijse.DTO;

public class PersonDTO {
    private String uId;
    private String userName;
    private String password;
    private String confirmPassword;

    public PersonDTO() {
    }

    public PersonDTO(String uId, String userName, String password, String confirmPassword) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public PersonDTO(String userName, String password, String confirmPassword) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public PersonDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public PersonDTO(String uId) {
        this.uId = uId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
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
        return "UserDto{" +
                "uId='" + uId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
