package com.offroadrepairservice.model.dto;

import java.util.List;
import java.util.Set;

public class CartDTO {

    private List<PartDTO> cart;

    public CartDTO() {
    }

    public List<PartDTO> getCart() {
        return cart;
    }

    public void setCart(List<PartDTO> cart) {
        this.cart = cart;
    }
}
