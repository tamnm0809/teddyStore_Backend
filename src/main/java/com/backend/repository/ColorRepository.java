package com.backend.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, String>{
    @Query( value = "SELECT c.color , COUNT(c.color)" +
    "FROM DETAILS_PRODUCT dp " +
    "JOIN PRODUCT p ON p.id = dp.id_pro "+
    "JOIN COLOR c ON c.id = dp.id_color " +
    "WHERE p.id = :id GROUP BY  c.color" , nativeQuery=true)
    List<Object[]> getColorById(@Param("id") String id);

}
