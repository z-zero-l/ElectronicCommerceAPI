package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Address;
import com.shopping.shoppingApi.mapper.AddressMapper;
import com.shopping.shoppingApi.service.AddressService;
import com.shopping.shoppingApi.vo.AddressVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.shopping.shoppingApi.entity.table.AddressTableDef.ADDRESS;

/**
 * 用户地址信息表 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    /**
     * 根据用户Id获取用户地址列表。
     *
     * @param userId 用户id
     * @return 地址列表
     */
    @Override
    public List<AddressVO> getAddressList(Integer userId) {
        ArrayList<AddressVO> addressVOS = new ArrayList<>();
        list(QueryChain.create().where(ADDRESS.USER_ID.eq(userId))).forEach(address -> addressVOS.add(AddressVO.create()
                .setId(address.getId())
                .setReceiver(address.getReceiver())
                .setContact(address.getContact())
                .setAddress(address.getAddress())
                .setIsDefault(address.getIsDefault())));
        return addressVOS;
    }
}
