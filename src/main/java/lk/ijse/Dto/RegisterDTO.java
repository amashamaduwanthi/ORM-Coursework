package lk.ijse.Dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterDTO {
    private String userName;

    private String nic;
    private String email;
    private String address;
    private String tel;
    private String password;
    private String userID;
}
