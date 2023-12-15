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
     * 添加用户地址。
     *
     * @param addressVO 用户地址信息表
     */
    @PostMapping("save")
    @Operation(description = "保存用户地址信息表",summary = "保存用户地址信息表")
    public ResponseEntity<Result<Void>> save(@RequestBody @Parameter(description = "用户地址信息表") AddressVO addressVO) {
        return Result.ok(addressService.addAddress(getUserId(request), addressVO)).responseEntity();
    }


    /**
     * 更新用户地址信息。
     *
     * @param addressVO 用户地址信息
     */
    @PutMapping("update")
    @Operation(description = "根据主键更新用户地址信息表",summary = "根据主键更新用户地址信息表")
    public ResponseEntity<Result<Void>> update(@RequestBody @Parameter(description = "用户地址信息表主键") AddressVO addressVO) {
        return Result.ok(addressService.updateAddress(getUserId(request), addressVO)).responseEntity();
    }

    /**
     * 删除用户地址信息。
     *
     * @param addressId 主键
     */
    @DeleteMapping("remove")
    @Operation(description = "根据主键删除用户地址信息表",summary = "根据主键用户地址信息表")
    public ResponseEntity<Result<Void>> remove(@Parameter(description = "用户地址信息表主键") Integer addressId) {
        return Result.ok(addressService.deleteAddress(getUserId(request), addressId)).responseEntity();
    }
}
