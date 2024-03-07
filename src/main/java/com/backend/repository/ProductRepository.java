package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query(value = "SELECT TOP 8 p.id, p.name, MIN(pi.img_url) FROM Size s "
			+ "JOIN Details_Product dp ON dp.id_size = s.id "
			+ "JOIN Product p ON p.id = dp.id_pro "
			+ "JOIN Product_Image pi ON pi.id_pro = p.id "
			+ "GROUP BY p.id, p.name", nativeQuery = true)
	List<Object[]> findAllProducts();

	@Query(value = "SELECT p.id, p.name, MIN(pi.img_url) FROM Size s "
			+ "JOIN Details_Product dp ON dp.id_size = s.id "
			+ "JOIN Product p ON p.id = dp.id_pro "
			+ "JOIN Product_Image pi ON pi.id_pro = p.id "
			+ "JOIN Category c ON c.id = p.id_cate "
			+ "WHERE c.name = N'Thú bông' GROUP BY p.id, p.name", nativeQuery = true)
	List<Object[]> findAllWhereThuBong();
	
	@Query(value = "SELECT p.id, p.name, MIN(pi.img_url) FROM Size s "
			+ "JOIN Details_Product dp ON dp.id_size = s.id "
			+ "JOIN Product p ON p.id = dp.id_pro "
			+ "JOIN Product_Image pi ON pi.id_pro = p.id "
			+ "JOIN Category c ON c.id = p.id_cate "
			+ "WHERE c.name = N'Gấu bông hoạt hình' GROUP BY p.id, p.name", nativeQuery = true)
	List<Object[]> findAllWhereGauHoatHinh();
}
