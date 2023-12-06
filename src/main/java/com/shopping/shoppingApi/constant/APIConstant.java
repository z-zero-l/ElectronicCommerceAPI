package com.shopping.shoppingApi.constant;

public class APIConstant {
    /**
     * 请求头 认证名称
     */
    public final static String AUTHORIZATION = "Authorization";

    /**
     * token 加密密钥
     */
    public static String JWT_SECRET = "shoppingAPI";

    /**
     * redis 存 token 键名
     */
    public static String APP_NAME = "shoppingAPI";

    /**
     * 默认头像
     */
    public static String DEFAULT_AVATAR = "https://wg233-own.oss-cn-hangzhou.aliyuncs.com/cover.png";

    /**
     * token 过期时间 15天
     */
    public static long TOKEN_EXPIRE_TIME = 15 * 24 * 3600L;

    /**
     * 密码加密盐
     */
    public static String PASSWORD_SALT = System.getenv("PASSWORD_SALT");

}
