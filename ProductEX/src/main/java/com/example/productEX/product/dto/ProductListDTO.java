package com.example.productEX.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductListDTO {
    private Long pno;

    private String pname;

    private int price;

    private String pdesc;

    private String seller;

    private String imageName;

}
