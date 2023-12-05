package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Business;
import com.shopping.shoppingApi.mapper.BusinessMapper;
import com.shopping.shoppingApi.service.BusinessService;
import org.springframework.stereotype.Service;

/**
 * 店铺信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
