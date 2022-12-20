package jcw.camo_server.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginDTO {
    private String email;
    private String password;

    @Builder
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
