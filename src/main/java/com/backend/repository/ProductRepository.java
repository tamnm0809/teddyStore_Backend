package com.backend.repository;

import com.backend.model.Category;
import com.backend.model.DetailsProduct;
import com.backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


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
			+ "WHERE c.name = N'G?u bông ho?t h?nh' GROUP BY p.id, p.name", nativeQuery = true)
	List<Object[]> findAllWhereGauHoatHinh();

    @Query("SELECT a FROM Product a ORDER BY a.id DESC LIMIT 1")
    Optional<Product> findLastProduct();

    @Query("SELECT a FROM Product a JOIN FETCH a.detailsProduct dp WHERE a.active = :active")
    List<ProductRepositoryCustom> findAllByActive(Boolean active);

    @Query("""
                        SELECT p
                        FROM Product p
                         JOIN FETCH p.productImages
                         JOIN FETCH p.category
                         JOIN FETCH p.detailsProduct pd
                         JOIN FETCH pd.color
                            JOIN FETCH pd.size
                            WHERE p.active = true
            """)
    Page<ProductResponse> findAllProduct(Pageable pageable);

    @Query("""
                        SELECT p
                        FROM Product p
                         JOIN FETCH p.productImages
                         JOIN FETCH p.category
                         JOIN FETCH p.detailsProduct pd
                         JOIN FETCH pd.color
                            JOIN FETCH pd.size
                            WHERE p.active = true
                            AND p.name LIKE %:name%
            """)
    Page<ProductResponse> findAllProductByName(String name,Pageable pageable);

    // ð?i tý?ng tr? v? c?a câu query, vi?t hàm getter,  Mu?n l?y trý?ng thông tin nào th? vi?t hàm getter cho trý?ng ðó ð? l?y
    interface ProductResponse {
        String getId();

        String getName();

        String getDescription();

        Boolean getActive();

        CategoryResponse getCategory();
        Set<ProductImageResponse> getProductImages();
        Set<DetailProductResponse> getDetailsProduct();

        interface ProductImageResponse {
            String getId();

            String getImg_url();
        }

        interface CategoryResponse {
            String getId();

            String getName();
        }

        interface DetailProductResponse {
            String getId();

            double getPrice();

            int getQuantity();

            SizeResponse getSize();

            ColorResponse getColor();

            interface SizeResponse {
                String getId();

                String getSize_no();
            }

            interface ColorResponse {
                String getId();

                String getColor();
            }
        }
    }

    interface ProductRepositoryCustom {
        String getId();

        String getName();

        Boolean getActive();

        Set<DetailProductResponse> getDetailsProduct();

        interface DetailProductResponse {
            String getId();

            double getPrice();
        }
    }
}
