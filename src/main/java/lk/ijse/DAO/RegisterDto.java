package lk.ijse.DAO;

import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RegisterDto {
    private String userName;

    private String nic;
    private String email;
    private String address;
    private String tel;
    private String password;
    private String userID;
}
