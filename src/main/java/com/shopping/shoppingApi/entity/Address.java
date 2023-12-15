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
 * 用户地址信息表 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户地址信息表")
@Table(value = "t_address")
public class Address extends Model<Address> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Integer userId;

    /**
     * 收件人
     */
    @Schema(description = "收件人")
    private String receiver;

    /**
     * 联系方式
     */
    @Schema(description = "联系方式")
    private String contact;

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
     * 详细地址
     */
    @Schema(description = "详细地址")
    private String address;

    /**
     * 默认地址(0-非默认 1-是默认)
     */
    @Schema(description = "默认地址(0-非默认 1-是默认)")
    private Integer isDefault;

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
