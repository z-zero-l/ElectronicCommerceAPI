package com.shopping.shoppingApi.controller;

import com.mybatisflex.core.paginate.Page;
import com.shopping.shoppingApi.common.result.Result;
import com.shopping.shoppingApi.entity.Address;
import com.shopping.shoppingApi.service.AddressService;
import com.shopping.shoppingApi.vo.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.shopping.shoppingApi.common.utils.ObtainUserIdUtils.getUserId;

/**
 * 用户地址信息表 控制层。
 *
 * @author wg233
 * @since 2023-12-04
 */
@RestController
@Tag(name = "地址模块")
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Resource
    private HttpServletRequest request;

    @GetMapping("list")
    @Operation(description = "查询用户地址信息表列表", summary = "查询用户地址信息表列表")
    public ResponseEntity<Result<List<AddressVO>>> list() {
        return Result.ok(addressService.getAddressList(getUserId(request))).responseEntity();
    }


    /**
     * 添加用户地址信息表。
     *
     * @param address 用户地址信息表
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("save")
    @Operation(description = "保存用户地址信息表")
    public boolean save(@RequestBody @Parameter(description = "用户地址信息表") Address address) {
        return addressService.save(address);
    }

    /**
     * 根据主键删除用户地址信息表。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    @Operation(description = "根据主键用户地址信息表")
    public boolean remove(@PathVariable @Parameter(description = "用户地址信息表主键") Serializable id) {
        return addressService.removeById(id);
    }

    /**
     * 根据主键更新用户地址信息表。
     *
     * @param address 用户地址信息表
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新用户地址信息表")
    public boolean update(@RequestBody @Parameter(description = "用户地址信息表主键") Address address) {
        return addressService.updateById(address);
    }

//    /**
//     * 查询所有用户地址信息表。
//     *
//     * @return 所有数据
//     */
//    @GetMapping("list")
//    @Operation(description = "查询所有用户地址信息表")
//    public List<Address> list() {
//        return addressService.list();
//    }

    /**
     * 根据用户地址信息表主键获取详细信息。
     *
     * @param id 用户地址信息表主键
     * @return 用户地址信息表详情
     */
    @GetMapping("getInfo/{id}")
    @Operation(description = "根据主键获取用户地址信息表")
    public Address getInfo(@PathVariable Serializable id) {
        return addressService.getById(id);
    }

    /**
     * 分页查询用户地址信息表。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    @Operation(description = "分页查询用户地址信息表")
    public Page<Address> page(@Parameter(description = "分页信息") Page<Address> page) {
        return addressService.page(page);
    }

}
