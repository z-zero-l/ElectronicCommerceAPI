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
 * 商品规格 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "商品规格")
@Table(value = "t_product_spec")
public class ProductSpec extends Model<ProductSpec> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer id;

    /**
     * 商品id
     */
    @Schema(description = "商品id")
    private Integer productId;

    /**
     * 商品规格名称
     */
    @Schema(description = "商品规格名称")
    private String specName;

    /**
     * 标价
     */
    @Schema(description = "标价")
    private Double listPrice;

    /**
     * 售价
     */
    @Schema(description = "售价")
    private Double sellPrice;

    /**
     * 库存
     */
    @Column(version = true)
    @Schema(description = "库存")
    private Integer stock;

    /**
     * 商品规格图片
     */
    @Schema(description = "商品规格图片")
    private String specImg;

    /**
     * 逻辑删除(0-未删除，1-已删除)
     */
    @Schema(description = "逻辑删除(0-未删除，1-已删除)")
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
