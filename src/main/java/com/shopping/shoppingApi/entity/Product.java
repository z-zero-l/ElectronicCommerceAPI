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
 * 商品表 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "商品表")
@Table(value = "t_product")
public class Product extends Model<Product> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer productId;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String productName;

    /**
     * 所属店铺
     */
    @Schema(description = "所属店铺")
    private Integer businessId;

    /**
     * 二级分类id
     */
    @Schema(description = "二级分类id")
    private Integer cateSecId;

    /**
     * 商品简介
     */
    @Schema(description = "商品简介")
    private String productProfile;

    /**
     * 商品封面图片
     */
    @Schema(description = "商品封面图片")
    private String productCover;

    /**
     * 运费
     */
    @Schema(description = "运费")
    private Double freight;

    /**
     * 商品状态(1-已上架 2-已下架)
     */
    @Schema(description = "商品状态(1-已上架 2-已下架)")
    private Integer productStatus;

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
