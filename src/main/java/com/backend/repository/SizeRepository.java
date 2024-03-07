package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, String>{
	
	@Query(value = "SELECT S.id,S.size_no,DP.price FROM SIZE S "
	        + "JOIN DETAILS_PRODUCT DP ON DP.id_size=S.id "
	        + "JOIN PRODUCT P ON P.id=DP.id_pro "
	        + "WHERE P.ID = :productId "
	        + "GROUP BY S.id,S.size_no,DP.price", nativeQuery = true)
	public List<Object[]> findByIdWhere(@Param("productId") String productId);

	
}
