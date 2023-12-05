package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Address;
import com.shopping.shoppingApi.mapper.AddressMapper;
import com.shopping.shoppingApi.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * 用户地址信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
