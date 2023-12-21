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
        // 如果收件人为空，则抛出运行时异常
        if (addressVO.getReceiver().isEmpty()) {
            throw new RuntimeException("收件人不能为空");
        }
        // 如果联系方式为空，则抛出运行时异常
        if (addressVO.getContact().isEmpty()) {
            throw new RuntimeException("联系方式不能为空");
        }
        // 如果省份编码为空，则抛出运行时异常
        if (addressVO.getProvinceCode() == null) {
            throw new RuntimeException("省份编码不能为空");
        }
        // 如果城市编码为空，则抛出运行时异常
        if (addressVO.getCityCode() == null) {
            throw new RuntimeException("城市编码不能为空");
        }
        // 如果区县编码为空，则抛出运行时异常
        if (addressVO.getDistrictCode() == null) {
            throw new RuntimeException("区县编码不能为空");
        }
        // 如果详细地址为空，则抛出运行时异常
        if (addressVO.getAddress().isEmpty()) {
            throw new RuntimeException("详细地址不能为空");
        }
        // 如果默认地址为空，则将默认地址设置为0
        if (addressVO.getIsDefault() == null) {
            addressVO.setIsDefault(0);
        } else {
            // 如果默认地址为1，则将同为默认地址的其他地址的默认地址设置为0
            if (addressVO.getIsDefault() == 1) {
                Address address = getOne(QueryChain.create().where(ADDRESS.USER_ID.eq(userId)).and(ADDRESS.IS_DEFAULT.eq(1)));
                if (address != null) {
                    address.setIsDefault(0);
                    updateById(address);
                }
            }
        }
        // 创建地址对象并设置相应的属性值
        Address address = Address.create()
                .setUserId(userId) // 用户id
                .setReceiver(addressVO.getReceiver()) // 收件人
                .setContact(addressVO.getContact()) // 联系方式
                .setProvinceCode(addressVO.getProvinceCode()) // 省份编码
                .setCityCode(addressVO.getCityCode()) //  城市编码
                .setDistrictCode(addressVO.getDistrictCode()) //  区县编码
                .setAddress(addressVO.getAddress()) //  详细地址
                .setIsDefault(addressVO.getIsDefault()); // 是否为默认地址
        // 将地址对象保存到数据库，如果保存失败，则抛出运行时异常
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
        // 判断地址是否存在
        if (!exists(QueryChain.create().where(ADDRESS.ID.eq(addressVO.getId())).and(ADDRESS.USER_ID.eq(userId)))) {
            throw new RuntimeException("地址不存在");
        }
        // 判断收件人是否为空
        if (addressVO.getReceiver().isEmpty()) {
            throw new RuntimeException("收件人不能为空");
        }
        // 判断联系方式是否为空
        if (addressVO.getContact().isEmpty()) {
            throw new RuntimeException("联系方式不能为空");
        }
        // 判断省份编码是否为空
        if (addressVO.getProvinceCode() == null) {
            throw new RuntimeException("省份编码不能为空");
        }
        // 判断城市编码是否为空
        if (addressVO.getCityCode() == null) {
            throw new RuntimeException("城市编码不能为空");
        }
        // 判断区县编码是否为空
        if (addressVO.getDistrictCode() == null) {
            throw new RuntimeException("区县编码不能为空");
        }
        // 判断详细地址是否为空
        if (addressVO.getAddress().isEmpty()) {
            throw new RuntimeException("详细地址不能为空");
        }
        // 判断默认地址标志是否为空，如果没有默认地址则设置为0，如果有默认地址且标志为1，则更新其他默认地址的默认标志为0
        if (addressVO.getIsDefault() == null) {
            addressVO.setIsDefault(0);
        } else {
            if (addressVO.getIsDefault() == 1) {
                Address address = getOne(QueryChain.create().where(ADDRESS.USER_ID.eq(userId)).and(ADDRESS.IS_DEFAULT.eq(1)));
                if (address != null) {
                    address.setIsDefault(0);
                    updateById(address);
                }
            }
        }
        // 创建新的地址对象并更新数据库
        Address address = Address.create()
                .setId(addressVO.getId())
                .setUserId(userId)
                .setReceiver(addressVO.getReceiver())
                .setContact(addressVO.getContact())
                .setProvinceCode(addressVO.getProvinceCode())
                .setCityCode(addressVO.getCityCode())
                .setDistrictCode(addressVO.getDistrictCode())
                .setAddress(addressVO.getAddress())
                .setIsDefault(addressVO.getIsDefault());
        if (!updateById(address)) {
            throw new RuntimeException("更新地址失败");
        }
        return null;
    }


    /**
     * 删除指定用户的地址
     *
     * @param userId    用户id
     * @param addressId 地址id
     */
    @Override
    public Void deleteAddress(Integer userId, Integer addressId) {
        // 检查地址是否存在
        if (!exists(QueryChain.create().where(ADDRESS.ID.eq(addressId)).and(ADDRESS.USER_ID.eq(userId)))) {
            throw new RuntimeException("地址不存在");
        } else {
            // 删除地址
            if (!removeById(addressId)) {
                throw new RuntimeException("删除地址失败");
            }
        }
        return null;
    }


}
