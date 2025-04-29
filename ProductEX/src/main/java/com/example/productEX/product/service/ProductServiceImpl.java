package com.example.productEX.product.service;

import com.example.productEX.product.dto.ProductAddDTO;
import com.example.productEX.product.entities.ProductEntity;
import com.example.productEX.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;


    @Override
    public Long add(ProductAddDTO dto) {
        ProductEntity productEntity = addDTOToEntity(dto);

        repository.save(productEntity);
        return productEntity.getPno();

    }
}
