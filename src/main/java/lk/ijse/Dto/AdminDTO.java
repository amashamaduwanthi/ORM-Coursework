package lk.ijse.Dto;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDTO {
    private long id;
    private String username;
    private String password;
}
