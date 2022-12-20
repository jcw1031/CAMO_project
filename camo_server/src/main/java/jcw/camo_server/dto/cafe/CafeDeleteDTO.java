package jcw.camo_server.dto.cafe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CafeDeleteDTO {
    private String cafeId;
    private String userPassword;

    @Builder
    public CafeDeleteDTO(String cafeId, String userPassword) {
        this.cafeId = cafeId;
        this.userPassword = userPassword;
    }
}
