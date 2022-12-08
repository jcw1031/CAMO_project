package jcw.camo_server.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginDTO {
    private String email;
    private String password;
}
