package com.zmhomecn.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zmhomecn.config.OrderProperties;
import com.zmhomecn.entity.Item;
import com.zmhomecn.feign.ItemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ItemService {
    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;
    @Value("${mycloud.item.url}")
    private String itemUrl;

    @Autowired
    OrderProperties orderProperties;
    @Resource
    private ItemFeignClient itemFeignClient;


    public Item queryItemById(Long id) {
       /* return this.restTemplate.getForObject("http://127.0.0.1:9091/item/"
                + id, Item.class);*/
        //return this.restTemplate.getForObject(itemUrl+ id, Item.class);
        return this.restTemplate.getForObject(orderProperties.getItem().getUrl()
                + id, Item.class);
    }

    //@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    //使用  feign
    public Item queryItemById3(Long id) {
       /* return this.restTemplate.getForObject("http://127.0.0.1:9091/item/"
                + id, Item.class);*/
        //return this.restTemplate.getForObject(itemUrl+ id, Item.class);
        //return this.restTemplate.getForObject(orderProperties.getItem().getUrl()+ id, Item.class);

        //fegin
        return itemFeignClient.queryItemById(id);
    }

    /**
     * 请求失败执行的方法
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id
     * @return
     */
    public Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "查询商品信息出错!", null, null, null);
    }

}
