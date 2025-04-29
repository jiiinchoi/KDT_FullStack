package com.example.productEX.product.service;


import com.example.productEX.product.dto.ProductAddDTO;
import com.example.productEX.product.entities.ProductEntity;


public interface ProductService {
    Long add(ProductAddDTO dto);



    default ProductEntity addDTOToEntity(ProductAddDTO dto) {
        ProductEntity entity = ProductEntity.builder()
                .pname(dto.getPname())
                .price(dto.getPrice())
                .seller(dto.getSeller())
                .pdesc(dto.getPdesc())
                .build();

        dto.getImageNames().forEach(imgName -> {entity.addImage(imgName);});

        return entity;
    }


}
