package com.example.productEX.product.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductAddDTO {
    private String pname;
    private int price;
    private String pdesc;
    private String seller;

    private List<String> imageNames;
}
