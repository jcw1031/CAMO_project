package jcw.CAMO_Server.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue
    private Long memberId;

    private String email;
    private String password;
    private String name;
    private String phone;
    private int memberType;
}
