package com.shopping.shoppingApi.entity;

import com.mybatisflex.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.mybatisflex.core.activerecord.Model;
import com.mybatisflex.core.mask.MaskManager;
import com.mybatisflex.core.mask.Masks;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户信息表 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户信息表")
@Table(value = "t_user")
public class User extends Model<User> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer userId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @ColumnMask(Masks.CHINESE_NAME)
    private String userName;

    /**
     * 账号
     */
    @Schema(description = "账号")
    private String account;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @ColumnMask(Masks.PASSWORD)
    private String password;

    /**
     * 性别(0-男 1-女)
     */
    @Schema(description = "性别(0-男 1-女)")
    private Integer gender;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @ColumnMask(Masks.EMAIL)
    private String email;

    /**
     * 联系方式
     */
    @Schema(description = "联系方式")
    @ColumnMask(Masks.FIXED_PHONE)
    private String phone;

    /**
     * 生日
     */
    @Schema(description = "生日")
    private LocalDateTime birthday;

    /**
     * 个人简介
     */
    @Schema(description = "个人简介")
    private String profile;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 省份编码
     */
    @Schema(description = "省份编码")
    private Integer provinceCode;

    /**
     * 城市编码
     */
    @Schema(description = "城市编码")
    private Integer cityCode;

    /**
     * 区县编码
     */
    @Schema(description = "区县编码")
    private Integer districtCode;

    /**
     * 逻辑删除(0-未删除 1-已删除)
     */
    @Schema(description = "逻辑删除(0-未删除 1-已删除)")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @Column(onInsertValue = "now()", isLarge = true)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(onInsertValue = "now()", onUpdateValue = "now()", isLarge = true)
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
