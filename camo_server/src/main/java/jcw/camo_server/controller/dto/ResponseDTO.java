package jcw.camo_server.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResponseDTO {
    private int status;
    private String message;
//    private Object data;

    @Builder
    public ResponseDTO(int status, String message/*, Object data*/) {
        this.status = status;
        this.message = message;
//        this.data = data;
    }
}
