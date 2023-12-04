package com.shopping.shoppingApi.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.mybatisflex.core.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 购物车 实体类。
 *
 * @author 18851
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "购物车")
@Table(value = "t_cart")
public class Cart extends Model<Cart> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer cartId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Integer userId;

    /**
     * 商品id
     */
    @Schema(description = "商品id")
    private Integer productId;

    /**
     * 商品规格id
     */
    @Schema(description = "商品规格id")
    private Integer specId;

    /**
     * 数量
     */
    @Schema(description = "数量")
    private Integer quantity;

    /**
     * 加入时商品价格
     */
    @Schema(description = "加入时商品价格")
    private Double joinPrice;

    /**
     * 是否选中(0-未选中 1-已选中)
     */
    @Schema(description = "是否选中(0-未选中 1-已选中)")
    private Integer selected;

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
