package com.example.productEX.product.dto;

import com.example.productEX.product.entities.ProductEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductReadDTO {

    private Long pno;
    private String pname;
    private String pdesc;
    private String seller;
    private List<String> imageNames;

    public ProductReadDTO(ProductEntity entity) {
        this.pno = entity.getPno();
        this.pname = entity.getPname();
        this.pdesc = entity.getPdesc();
        this.seller = entity.getSeller();
        this.imageNames = entity.getImages().stream().map(image -> image.getImageName()).collect(Collectors.toList());
    }
}
