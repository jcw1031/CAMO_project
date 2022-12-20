package jcw.camo_server.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class WithdrawalDTO {
    private Long userId;
    private String password;

    @Builder
    public WithdrawalDTO(Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
