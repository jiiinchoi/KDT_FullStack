package com.example.productEX.product;

import com.example.productEX.product.entities.ProductEntity;
import com.example.productEX.product.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
@Log4j2
public class ProductRepoTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testInsertProducts() {

        for (int i = 1; i <= 15; i++) {

            ProductEntity product = ProductEntity.builder()
                    .pname("상품 " + i)
                    .price(5000 + i * 100)  // 가격 5100, 5200, ...
                    .pdesc("설명입니다: " + i + "번 상품은 특별한 커피입니다.")
                    .seller("seller_" + ((i % 5) + 1))  // seller_1 ~ seller_5 반복
                    .build();

            // 대표 이미지 포함 3장 등록
            product.addImage("sample" + i + "_1.jpg");
            product.addImage("sample" + i + "_2.jpg");
            product.addImage("sample" + i + "_3.jpg");

            productRepository.save(product);

        }

    }

    @Test
    public void testList1() {
        Pageable pageable = PageRequest.of(0, 10);  // 1페이지, 10개씩
        Page<Object[]> result = productRepository.list1(pageable);

        result.getContent().forEach(arr -> {
            System.out.println("pno: " + arr[0]);
            System.out.println("pname: " + arr[1]);
            System.out.println("price: " + arr[2]);
            System.out.println("imgName: " + arr[3]);
            System.out.println("-------------------");
        });
    }

    @Test
    public void testSelectOne() {

        Long pno = 1L;

        ProductEntity product = productRepository.selectOne(pno);

        log.info("===== 상품 정보 =====");
        log.info("상품 번호: {}", product.getPno());
        log.info("상품명: {}", product.getPname());
        log.info("가격: {}", product.getPrice());
        log.info("설명: {}", product.getPdesc());
        log.info("판매자: {}", product.getSeller());

        log.info("===== 이미지 리스트 =====");
        product.getImages().forEach(img -> {
            log.info("이미지 파일명: {}", img.getImageName());
            log.info("순서: {}", img.getOrd());
        });
    }
}
