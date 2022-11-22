package jcw.camo_server.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private int role;

    public User(Long id, String email, String password, String name, String phone, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }
}
