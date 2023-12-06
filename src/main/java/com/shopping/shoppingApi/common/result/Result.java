package com.shopping.shoppingApi.common.result;

import com.shopping.shoppingApi.common.exception.ErrorCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Schema(description = "响应数据")
public class Result<T> {
    @Schema(description = "响应数据")
    private T result;

    public static <T> RespBean ok() {
        return ok(null).getBody();
    }


    public static <T> ResponseEntity<RespBean> ok(T data) {
        return new RespBean(200, "success", data).responseEntity();
    }


    public static <T> ResponseEntity<RespBean> error() {
        return error(ErrorCode.INTERNAL_SERVER_ERROR);
    }


    public static <T> ResponseEntity<RespBean> error(String msg) {
        return error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static <T> ResponseEntity<RespBean> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }


    public static <T> ResponseEntity<RespBean> error(int code, String msg) {
        return new RespBean(code,msg).responseEntity();
    }
}