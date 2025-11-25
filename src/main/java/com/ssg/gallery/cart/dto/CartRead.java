package com.ssg.gallery.cart.dto;


import lombok.Builder;
import lombok.Getter;

//CartRead : 장바구니 조회 DTO
@Getter
@Builder
public class CartRead {

    private Integer id;
    private Integer itemId;

}
