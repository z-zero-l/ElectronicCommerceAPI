package com.shopping.shoppingApi.common.result;

import com.shopping.shoppingApi.common.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Schema(description = "响应数据")
public class Result<T> {
    @Schema(description = "编码 200 表示成功，其他值表示失败")
    private int code = 200;

    @Schema(description = "消息内容")
    private String msg = "success";

    @Schema(description = "响应数据")
    private T data;

    public static <T> Result<T> ok() {
        return ok(null);
    }


    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }


    public static <T> Result<T> error() {
        return error(ErrorCode.INTERNAL_SERVER_ERROR);
    }


    public static <T> Result<T> error(String msg) {
        return error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }


    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public ResponseEntity<Result<T>> responseEntity() {
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