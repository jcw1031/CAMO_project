package jcw.camo_server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class UserUpdateDto{
    private Long userId;
    private String password;
    private String name;
    private String phone;
}
