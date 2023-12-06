package com.shopping.shoppingApi.common.result;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class RespBean {
    private Integer code = 0;
    private String msg;
    private Object obj;

    public RespBean(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public RespBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseEntity<RespBean> responseEntity() {
        return switch (code) {
            case 200 -> ResponseEntity.ok(this);
            case 400 -> ResponseEntity.badRequest().body(this);
            case 401 -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(this);
            case 404 -> ResponseEntity.notFound().build();
            case 500 -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this);
            default -> ResponseEntity.status(code).body(this);
        };
    }
}

