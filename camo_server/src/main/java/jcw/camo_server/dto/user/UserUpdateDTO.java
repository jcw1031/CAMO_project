package jcw.camo_server.dto.user;

import lombok.*;

@Getter @Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private Long userId;
    private String password;
    private String name;
    private String phone;
}
