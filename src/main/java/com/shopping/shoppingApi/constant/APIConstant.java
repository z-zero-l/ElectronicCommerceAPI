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
    public static String DEFAULT_AVATAR = "https://wg233-own.oss-cn-hangzhou.aliyuncs.com/avatar/5924d882ef5d27db3dfb41bf7be964cb4de7ec9ddc5aed6f2fe821b197938b1e.png";

    /**
     * token 过期时间 15天
     */
    public static long TOKEN_EXPIRE_TIME = 15 * 24 * 3600L;

    /**
     * 密码加密盐
     */
    public static String PASSWORD_SALT = System.getenv("PASSWORD_SALT");

}
