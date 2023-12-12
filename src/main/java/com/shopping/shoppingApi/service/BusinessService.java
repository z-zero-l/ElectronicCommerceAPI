package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.vo.BusinessVO;

/**
 * 店铺信息表 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface BusinessService extends IService<Business> {

    /**
     * 获取店铺信息
     *
     * @param businessId 店铺id
     * @return 店铺信息
     */
    BusinessVO getBusinessInfo(Integer businessId);
}
