package jcw.camoServer.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class LoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
