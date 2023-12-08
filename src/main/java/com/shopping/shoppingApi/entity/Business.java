package com.shopping.shoppingApi.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 店铺信息表 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "店铺信息表")
@Table(value = "t_business")
public class Business extends Model<Business> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 店铺账号
     */
    @Schema(description = "店铺账号")
    private String businessAccount;

    /**
     * 登录密码
     */
    @Schema(description = "登录密码")
    private String password;

    /**
     * 店铺名称
     */
    @Schema(description = "店铺名称")
    private String businessName;

    /**
     * 店铺联系方式
     */
    @Schema(description = "店铺联系方式")
    private String businessPhone;

    /**
     * 店主id
     */
    @Schema(description = "店主id")
    private Integer businessOwner;

    /**
     * 店铺简介
     */
    @Schema(description = "店铺简介")
    private String businessProfile;

    /**
     * 店铺头像
     */
    @Schema(description = "店铺头像")
    private String businessAvatar;

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
