package com.example.demoajax.repository;

import com.example.demoajax.query.Demo;
import com.example.demoajax.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

// Truyền Product và kiểu dữ liệu của ID
public interface IProductRepo extends PagingAndSortingRepository<Product, Long> {
    @Query(nativeQuery = true, value = "select count(id) from product")
    Long countProduct();

    @Query(nativeQuery = true, value = "select product.name as NameProduct, Img, category.name as NameCategory from product join category on product.category_id = category.id")
    List<Demo> getDemo();


    // Name, img, category
}
