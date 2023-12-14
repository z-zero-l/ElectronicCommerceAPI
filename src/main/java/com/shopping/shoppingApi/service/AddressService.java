package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Address;
import com.shopping.shoppingApi.vo.AddressVO;

import java.util.List;

/**
 * 用户地址信息表 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface AddressService extends IService<Address> {

    /**
     * 根据用户Id获取用户地址列表。
     *
     * @param userId 用户id
     * @return 地址列表
     */
    List<AddressVO> getAddressList(Integer userId);

    /**
     * 添加地址
     *
     * @param userId    用户id
     * @param addressVO 地址对象
     */
    Void addAddress(Integer userId, AddressVO addressVO);

    /**
     * 更新地址
     *
     * @param userId    用户id
     * @param addressVO 地址对象
     */
    Void updateAddress(Integer userId, AddressVO addressVO);

    /**
     *
     * @param userId 用户id
     * @param addressId 地址id
     */
    Void deleteAddress(Integer userId, Integer addressId);

}
