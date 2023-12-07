package com.shopping.shoppingApi.common.utils;

import com.shopping.shoppingApi.common.exception.ServerException;
import jakarta.servlet.http.HttpServletRequest;

public class ObtainUserIdUtils {

    public static Long getUserId(HttpServletRequest request) {
        if (request.getAttribute("userId") == null) {
            throw new ServerException("用户不存在");
        }
        Long userId = Long.parseLong(request.getAttribute("userId").toString());
        if (userId == null) {
            throw new ServerException("用户不存在");
        }
        return userId;
    }
}