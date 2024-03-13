package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@ToString
public class Person {
    @Id
    private String userName;
    private String email;
    private String password;
    private String repassword;
    private String userID;



}


