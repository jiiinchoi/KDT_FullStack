package com.example.productEX.product.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="tbl_product")
@Getter
@ToString (exclude = "images")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;

    private String pdesc;

    private String seller;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "tbl_product_img",
            joinColumns = @JoinColumn(name="product_pno"))
    @Builder.Default
    private List<ProductImageEntitiy> images = new ArrayList<>();

    public void addImage(String fileName) {
        ProductImageEntitiy image = new ProductImageEntitiy();
        image.setImageName(fileName);
        image.setOrd(images.size());

        images.add(image);
    }

}
