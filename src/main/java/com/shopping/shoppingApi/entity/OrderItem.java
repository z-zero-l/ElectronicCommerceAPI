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
 * 订单详情 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "订单详情")
@Table(value = "t_order_item")
public class OrderItem extends Model<OrderItem> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 订单id
     */
    @Schema(description = "订单id")
    private Integer orderId;

    /**
     * 商品id
     */
    @Schema(description = "商品id")
    private Integer productId;

    /**
     * 数量
     */
    @Schema(description = "数量")
    private Integer amount;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String productName;

    /**
     * 商品规格名称
     */
    @Schema(description = "商品规格名称")
    private String specName;

    /**
     * 商品详情图片
     */
    @Schema(description = "商品详情图片")
    private String productImage;

    /**
     * 实付款
     */
    @Schema(description = "实付款")
    private BigDecimal price;

    /**
     * 运费
     */
    @Schema(description = "运费")
    private Double freight;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 订单取消原因
     */
    @Schema(description = "订单取消原因")
    private String cancelReason;

    /**
     * 订单项状态(0-待付款 1-待发货 2-待收货 3-待评价 4-已完成 5-已取消)
     */
    @Schema(description = "订单项状态(0-待付款 1-待发货 2-待收货 3-待评价 4-已完成 5-已取消)")
    private Integer status;

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

    /**
     * 订单关闭类型(0-超时未支付 1-买家取消 2-退款关闭)
     */
    @Schema(description = "订单关闭类型(0-超时未支付 1-买家取消 2-退款关闭)")
    private Integer closeType;

    /**
     * 关闭时间
     */
    @Schema(description = "关闭时间")
    private LocalDateTime cancelTime;

    /**
     * 付款时间
     */
    @Schema(description = "付款时间")
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    @Schema(description = "发货时间")
    private LocalDateTime sendTime;

    /**
     * 收货时间
     */
    @Schema(description = "收货时间")
    private LocalDateTime receiptTime;

    /**
     * 完成时间
     */
    @Schema(description = "完成时间")
    private LocalDateTime finishTime;

}
