package com.zmhomecn.fallback;

import com.zmhomecn.entity.Item;
import com.zmhomecn.feign.ItemFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ItemServiceFallback implements ItemFeignClient {
    @Override
    public Item queryItemById(Long id) {
        return new Item(id, "查询商品信息出错!", null, null, null);
    }
}
