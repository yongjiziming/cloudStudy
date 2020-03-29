package com.zmhomecn.config;

import com.zmhomecn.properties.ItemProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mycloud")
public class OrderProperties {
    private ItemProperties item = new ItemProperties();

    public ItemProperties getItem() {
        return item;
    }

    public void setItem(ItemProperties item) {
        this.item = item;
    }
}
