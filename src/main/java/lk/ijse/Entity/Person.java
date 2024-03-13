package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Person {
    private String userName;
    @Id
    private String nic;
    private String email;
    private String address;
    private String tel;
    private String password;
    private String userID;

    public Person(String userName, String nic,String email, String address, String tel,String password,String userID) {
        this.userName = userName;
        this.nic = nic;
        this.email=email;
        this.address = address;
        this.tel = tel;
        this.password=password;
        this.userID=userID;
    }
    public Person(){

    }
    public Person(String nic,String userName,String newPw) {
        this.nic=nic;
        this.userName=userName;
        this.password=newPw;
    }

    @Override
    public String toString() {
        return userName+nic+email+address+tel+password+userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNic() {
        return nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}


