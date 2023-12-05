package com.shopping.shoppingApi.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shopping.shoppingApi.entity.Collect;
import com.shopping.shoppingApi.mapper.CollectMapper;
import com.shopping.shoppingApi.service.CollectService;
import org.springframework.stereotype.Service;

/**
 * 收藏 服务层实现。
 *
 * @author wg233
 * @since 2023-12-04
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

}
