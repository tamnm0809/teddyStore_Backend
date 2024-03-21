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

    // đối tượng trả về của câu query, viết hàm getter,  Muốn lấy trường thông tin nào thì viết hàm getter cho trường đó để lấy
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
