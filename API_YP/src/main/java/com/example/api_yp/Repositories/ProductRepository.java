package com.example.api_yp.Repositories;

import com.example.api_yp.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM product inner join shop on product_id = id_product where address =:address and name=:name", nativeQuery = true)
    List<Product> findProductByNameAndAddress (@Param("address")String address, @Param("name")String name);
}
