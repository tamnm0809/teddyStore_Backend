package com.backend.controller;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import com.backend.model.DetailsProduct;
import com.backend.model.ProductImage;
import com.backend.payload.ProductPayload;
import com.backend.repository.*;
import com.backend.util.CloudinaryUtil;
import com.backend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.backend.dto.ProductDTO;
import com.backend.services.ProductService;
import com.backend.model.Product;
import com.backend.services.ProductService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ProductController {
    ProductService proService;
    ProductRepository proRepository;
    DetailsProductRepository detailsProductRepository;
    ProductImageRepository productImageRepository;
    CategoryRepository categoryRepository;
    ColorRepository colorRepository;
    SizeRepository sizeRepository;

	@GetMapping("/getAllProduct")
	public List<ProductDTO> getAllProduct(){
		return proService.getAllProductDTO();
	}
	@GetMapping("/getAllProductWhere-Thu-Bong")
	public List<ProductDTO> getProductWhereThuBong(){
		return proService.getAllProductWhereThuBong();
	}
	
	@GetMapping("/getAllProductWhere-Gau-Bong-Hoat-Hinh")
	public List<ProductDTO> getProductWhereGauHoatHinh(){
		return proService.getAllProductWhereGauHoatHinh();
	}
	@GetMapping("/getAllProduct")
    public Object getAllProduct(@RequestParam("page") int page, @RequestParam("size") int size) {
        return proService.getAllProduct(page, size);
    }

    @GetMapping("getAllProductActive")
    public Object getAllProductActive() {
        return proService.getAllProductActive();
    }

    @GetMapping("searchProduct")
    public Object searchProduct(@RequestParam("textSearch") String textSearch) {
        return proService.searchProductByName(textSearch);
    }

    @PatchMapping("deleteProduct")
    public Object deleteProduct(@RequestBody ProductPayload productPayload) {
        var product = proRepository.findById(productPayload.getId());
        if (product.isPresent()) {
            product.get().setActive(Boolean.FALSE);
            proRepository.save(product.get());
            return "OK";
        }
        return "FAIL";
    }

    @PostMapping("updateProduct")
    public Object updateProduct(
            @RequestParam("description") String description,
            @RequestParam("idCate") String idCategory,
            @RequestParam("idColor") String idColor,
            @RequestParam("idSize") String idSize,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity,
            @RequestParam("images") List<MultipartFile> images
    ) {
        var lastProduct = proRepository.findLastProduct();
        var product = new Product();
        if (lastProduct.isPresent()) {
            product.setId(RandomUtil.getNextId(lastProduct
                                                       .get()
                                                       .getId(), "PR"));
        } else {
            product.setId(RandomUtil.getNextId(null, "PR"));
        }
        product.setName(name);
        product.setDescription(description);
        product.setActive(Boolean.TRUE);

        // set details product
        var lastDetailProduct = detailsProductRepository.findLastDetailsProduct();
        var detailProduct = new DetailsProduct();
        if (lastDetailProduct.isPresent()) {
            detailProduct.setId(RandomUtil.getNextId(lastDetailProduct
                                                             .get()
                                                             .getId(), "DP"));
        } else {
            detailProduct.setId(RandomUtil.getNextId(null, "DP"));
        }
        detailProduct.setPrice(price);
        detailProduct.setQuantity(quantity);
        detailProduct.setActive(Boolean.TRUE);
        var category = categoryRepository.findById(idCategory);
        var color = colorRepository.findById(idColor);
        var size = sizeRepository.findById(idSize);
        category.ifPresent(product::setCategory);
        color.ifPresent(detailProduct::setColor);
        size.ifPresent(detailProduct::setSize);
        detailProduct.setProduct(product);
        product.setDetailsProduct(Collections.singleton(detailProduct));
        var lastProductImage = productImageRepository.findLastProductImage();
        AtomicReference<String> productImageId = new AtomicReference<>("");
        List<ProductImage> setImages = new ArrayList<>();
        images.forEach(el -> {
            var productImage = new ProductImage();
            if(StringUtils.isEmpty(productImageId.get())){
                if (lastProductImage.isPresent()) {
                    productImageId.set(RandomUtil.getNextId(lastProductImage
                                                                    .get()
                                                                    .getId(), "PI"));
                } else {
                    productImageId.set(RandomUtil.getNextId(null, "PI"));
                }
            }else {
                productImageId.set(RandomUtil.getNextId(productImageId.get(), "PI"));
            }
            productImage.setId(productImageId.get());
            try {
                var url = CloudinaryUtil.uploadImage(el.getBytes());
                productImage.setImg_url(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            productImage.setProduct(product);
            setImages.add(productImage);
        });

        // set images
        product.setProductImages(new HashSet<>(setImages));
        return proService.updateProduct(product);
    }
}
