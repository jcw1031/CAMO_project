package jcw.camo_server.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class User {
    private Long userId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private int role;

    @Builder
    public User(Long userId, String email, String password, String name, String phone, int role) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }
}
