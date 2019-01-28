package com.paypayExamples.payment.pojo;

import java.util.List;

public class Item_List {

    public Shipping_address getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Shipping_address shipping_address) {
        this.shipping_address = shipping_address;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    private List<Items> items;
    private Shipping_address shipping_address;
}
