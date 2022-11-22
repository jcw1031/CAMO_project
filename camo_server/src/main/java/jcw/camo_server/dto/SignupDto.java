package jcw.camo_server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SignupDto {
    private String email;
    private String password;
    private String name;
    private String phone;
}
