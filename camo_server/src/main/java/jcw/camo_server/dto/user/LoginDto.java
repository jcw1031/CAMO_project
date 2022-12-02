package jcw.camo_server.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginDto {
    private String email;
    private String password;
}
