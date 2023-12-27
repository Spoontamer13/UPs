package com.example.api_yp.Repositories;

import com.example.api_yp.Models.Person;
import com.example.api_yp.Models.PersonShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonShopRepository extends JpaRepository<PersonShop,Long> {
    @Query(value="SELECT * FROM person_shop where person_id = :c", nativeQuery=true)
    List<PersonShop> findPersonShopByPerson (@Param("c")Long idPerson);
}
