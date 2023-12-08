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
 * 商品轮播图 实体类。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "商品轮播图")
@Table(value = "t_product_carousel_image")
public class ProductCarouselImage extends Model<ProductCarouselImage> {

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
     * 图片地址
     */
    @Schema(description = "图片地址")
    private String imgUrl;

    /**
     * 图片排序(越小越靠前)
     */
    @Schema(description = "图片排序(越小越靠前)")
    private Integer sort;

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
