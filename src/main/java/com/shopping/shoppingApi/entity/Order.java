package com.shopping.shoppingApi.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.mybatisflex.core.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 订单 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "订单")
@Table(value = "t_order")
public class Order extends Model<Order> {

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
     * 订单号
     */
    @Schema(description = "订单号")
    private String orderId;

    /**
     * 实付金额
     */
    @Schema(description = "实付金额")
    private BigDecimal payment;

    /**
     * 收货人
     */
    @Schema(description = "收货人")
    private String consignee;

    /**
     * 收货人联系方式
     */
    @Schema(description = "收货人联系方式")
    private String phone;

    /**
     * 收货省份编码
     */
    @Schema(description = "收货省份编码")
    private Integer provinceCode;

    /**
     * 收货城市编码
     */
    @Schema(description = "收货城市编码")
    private Integer cityCode;

    /**
     * 收货区县编码
     */
    @Schema(description = "收货区县编码")
    private Integer districtCode;

    /**
     * 收货详细地址
     */
    @Schema(description = "收货详细地址")
    private String address;

    /**
     * 逻辑删除
     */
    @Schema(description = "逻辑删除")
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
