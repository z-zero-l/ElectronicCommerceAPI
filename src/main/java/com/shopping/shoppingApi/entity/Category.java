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
 * 分类 实体类。
 *
 * @author 18851
 * @since 2023-12-04
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "分类")
@Table(value = "t_category")
public class Category extends Model<Category> {

    /**
     * 主键
     */
    @Id(keyType = KeyType.Auto)
    @Schema(description = "主键")
    private Integer categoryId;

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    private String cateName;

    /**
     * 分类图标
     */
    @Schema(description = "分类图标")
    private String cateIcon;

    /**
     * 颜色标识
     */
    @Schema(description = "颜色标识")
    private String cateColor;

    /**
     * 父级id(0-一级分类)
     */
    @Schema(description = "父级id(0-一级分类)")
    private Integer parentId;

    /**
     * 分类层级(1-一级分类 2-二级分类)
     */
    @Schema(description = "分类层级(1-一级分类 2-二级分类)")
    private Integer cateLevel;

    /**
     * 排序指数(排序越小越靠前)
     */
    @Schema(description = "排序指数(排序越小越靠前)")
    private Integer sort;

    /**
     * 是否推荐(1-首页推荐)
     */
    @Schema(description = "是否推荐(1-首页推荐)")
    private Integer isRecommend;

    /**
     * 分类简介
     */
    @Schema(description = "分类简介")
    private String cateProfile;

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
