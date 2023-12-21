package com.shopping.shoppingApi.common.interceptor;

import com.shopping.shoppingApi.common.exception.ErrorCode;
import com.shopping.shoppingApi.common.exception.ServerException;
import com.shopping.shoppingApi.common.utils.JWTUtils;
import com.shopping.shoppingApi.constant.APIConstant;
import com.shopping.shoppingApi.service.RedisService;
import com.shopping.shoppingApi.vo.UserTokenVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

/**
 * 执行拦截器的方法，用于预处理请求
 * @param request HTTP请求对象
 * @param response HTTP响应对象
 * @param handler 处理请求的对象
 * @return 预处理结果，返回true表示继续处理请求，返回false表示拦截请求
 * @throws Exception 异常情况
 */
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 从header中得到token
    String authorization = request.getHeader(APIConstant.AUTHORIZATION);
    if (authorization == null) {
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }
    // 如果token存在，需要验证token的真伪，如果 token 是真的，对 token 解析，获取用户id
    Map map = JWTUtils.getClaims(APIConstant.JWT_SECRET, authorization);
    if (map == null) {
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    } else {
        String userId = map.get("userId").toString();
        request.setAttribute("userId", userId);
    }
    // 判断token是否过期
    UserTokenVO userTokenVO = new UserTokenVO().fromMap(map);
    boolean isExist = redisService.existsKey(userTokenVO.getUserId().toString());
    if (isExist) {
        String originToken = redisService.getValue(userTokenVO.getUserId().toString(), String.class);
        if (originToken != null && originToken.equals(authorization)) {
            return true;
        } else {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
    }
    return true;
}
}
