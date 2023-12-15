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
        list(QueryChain.create().where(ADDRESS.USER_ID.eq(userId)).orderBy(ADDRESS.IS_DEFAULT.desc()).orderBy(ADDRESS.UPDATE_TIME.desc())).forEach(address -> addressVOS.add(AddressVO.create()
                .setId(address.getId())
                .setReceiver(address.getReceiver())
                .setContact(address.getContact())
                .setProvinceCode(address.getProvinceCode())
                .setCityCode(address.getCityCode())
                .setDistrictCode(address.getDistrictCode())
                .setAddress(address.getAddress())
                .setIsDefault(address.getIsDefault())));
        return addressVOS;
    }

    /**
     * 添加地址
     *
     * @param userId    用户id
     * @param addressVO 地址对象
     */
    @Override
    public Void addAddress(Integer userId, AddressVO addressVO) {
        if (addressVO.getReceiver()==null) {
            throw new RuntimeException("收件人不能为空");
        }
        if (addressVO.getContact()==null) {
            throw new RuntimeException("联系方式不能为空");
        }
        if (addressVO.getProvinceCode()==null) {
            throw new RuntimeException("省份编码不能为空");
        }
        if (addressVO.getCityCode()==null) {
            throw new RuntimeException("城市编码不能为空");
        }
        if (addressVO.getDistrictCode()==null) {
            throw new RuntimeException("区县编码不能为空");
        }
        if (addressVO.getAddress()==null) {
            throw new RuntimeException("详细地址不能为空");
        }
        if (addressVO.getIsDefault()==null) {
            addressVO.setIsDefault(0);
        }else {
            if (addressVO.getIsDefault()==1) {
                Address address = getOne(QueryChain.create().where(ADDRESS.USER_ID.eq(userId)).and(ADDRESS.IS_DEFAULT.eq(1)));
                address.setIsDefault(0);
                address.update();
            }
        }
        Address address = Address.create()
                .setUserId(userId)
                .setReceiver(addressVO.getReceiver())
                .setContact(addressVO.getContact())
                .setProvinceCode(addressVO.getProvinceCode())
                .setCityCode(addressVO.getCityCode())
                .setDistrictCode(addressVO.getDistrictCode())
                .setAddress(addressVO.getAddress())
                .setIsDefault(addressVO.getIsDefault());
        if (!save(address)) {
            throw new RuntimeException("添加地址失败");
        }
        return null;
    }

    /**
     * 更新地址
     *
     * @param userId    用户id
     * @param addressVO 地址对象
     */
    @Override
    public Void updateAddress(Integer userId, AddressVO addressVO) {
        if(!exists(QueryChain.create().where(ADDRESS.ID.eq(addressVO.getId())).and(ADDRESS.USER_ID.eq(userId)))){
            throw new RuntimeException("地址不存在");
        }
        if (addressVO.getReceiver()==null) {
            throw new RuntimeException("收件人不能为空");
        }
        if (addressVO.getContact()==null) {
            throw new RuntimeException("联系方式不能为空");
        }
        if (addressVO.getProvinceCode()==null) {
            throw new RuntimeException("省份编码不能为空");
        }
        if (addressVO.getCityCode()==null) {
            throw new RuntimeException("城市编码不能为空");
        }
        if (addressVO.getDistrictCode()==null) {
            throw new RuntimeException("区县编码不能为空");
        }
        if (addressVO.getAddress()==null) {
            throw new RuntimeException("详细地址不能为空");
        }
        if (addressVO.getIsDefault()==null) {
            addressVO.setIsDefault(0);
        }else {
            if (addressVO.getIsDefault()==1) {
                Address address = getOne(QueryChain.create().where(ADDRESS.USER_ID.eq(userId)).and(ADDRESS.IS_DEFAULT.eq(1)));
                address.setIsDefault(0);
                address.update();
            }
        }
        Address address = Address.create()
                .setUserId(userId)
                .setReceiver(addressVO.getReceiver())
                .setContact(addressVO.getContact())
                .setProvinceCode(addressVO.getProvinceCode())
                .setCityCode(addressVO.getCityCode())
                .setDistrictCode(addressVO.getDistrictCode())
                .setAddress(addressVO.getAddress())
                .setIsDefault(addressVO.getIsDefault());
        if (!save(address)) {
            throw new RuntimeException("添加地址失败");
        }
        return null;
    }

    /**
     * @param userId    用户id
     * @param addressId 地址id
     */
    @Override
    public Void deleteAddress(Integer userId, Integer addressId) {
        if(!exists(QueryChain.create().where(ADDRESS.ID.eq(addressId)).and(ADDRESS.USER_ID.eq(userId)))){
            throw new RuntimeException("地址不存在");
        }else {
            if (!removeById(addressId)) {
                throw new RuntimeException("删除地址失败");
            }
        }
        return null;
    }

}
