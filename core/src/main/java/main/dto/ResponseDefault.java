package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDefault {

    private String code;
    private String msg;
    private Object data;

    public ResponseDefault() {
        this.code = "0000";
        this.msg = "성공";
        this.data = "";
    }
}
