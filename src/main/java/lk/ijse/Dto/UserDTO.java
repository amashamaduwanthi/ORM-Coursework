package lk.ijse.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private String branch;
}
