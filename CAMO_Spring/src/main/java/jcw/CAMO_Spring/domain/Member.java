package jcw.CAMO_Spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int memberId; //회원번호(PK)
    private String email; //이메일 -> 아이디로 사용
    private String name; //이름
    private String password; //비밀번호
    private String phoneNumber; //전화번호
    private int memberType; //사장 권한
}