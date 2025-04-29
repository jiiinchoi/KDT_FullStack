package com.example.productEX.product.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@Setter
public class ProductImageEntitiy {

    private String imageName;

    private int ord;

}
