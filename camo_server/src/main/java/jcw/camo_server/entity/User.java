package jcw.camo_server.entity;

import lombok.*;

@Getter @Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private int role;
}
