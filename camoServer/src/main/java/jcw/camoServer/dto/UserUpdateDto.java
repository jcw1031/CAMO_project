package jcw.camoServer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserUpdateDto {

    private String password;
    private String name;
    private String phone;

    public UserUpdateDto(String password, String name, String phone) {
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}
