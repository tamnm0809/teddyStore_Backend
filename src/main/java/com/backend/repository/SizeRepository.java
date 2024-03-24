package com.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.backend.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, String>{
	
	@Query(value = "SELECT S.id,S.size_no,DP.price,DC.price_sale,DP.quantity FROM SIZE S "
	        + "JOIN DETAILS_PRODUCT DP ON DP.id_size=S.id "
			+ "JOIN DISCOUNT DC ON DC.id_dt_pro = DP.id "
	        + "JOIN PRODUCT P ON P.id=DP.id_pro "
	        + "WHERE P.ID = :productId "
	        + "GROUP BY S.id,S.size_no,DP.price,DC.price_sale,DP.quantity", nativeQuery = true)
	public List<Object[]> findByIdWhere(@Param("productId") String productId);
	
    @Query("SELECT a FROM Size a ORDER BY a.id DESC LIMIT 1")
    Optional<Size> findLastSize();
    @Query("SELECT c FROM Size c WHERE LOWER(c.size_no) LIKE %:sizeNo%")
    Page<Size> findAllByName(@Param("sizeNo") String sizeNo, Pageable pageable);

//	@Query(value = "SELECT S.id,S.size_no,DP.price FROM SIZE S "
//	        + "JOIN DETAILS_PRODUCT DP ON DP.id_size=S.id "
//	        + "JOIN PRODUCT P ON P.id=DP.id_pro "
//	        + "WHERE P.ID = :productId "
//	        + "GROUP BY S.id,S.size_no,DP.price", nativeQuery = true)
//	public List<Object[]> findByIdWheres(@Param("productId") String productId);

	
}
