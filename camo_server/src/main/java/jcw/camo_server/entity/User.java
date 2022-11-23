package jcw.camo_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class User {
    private Long userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private int role;
}
