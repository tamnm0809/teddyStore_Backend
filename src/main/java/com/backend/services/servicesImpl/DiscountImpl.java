package com.backend.services.servicesImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.DiscountDTO;
import com.backend.model.Discount;
import com.backend.repository.DiscountRepository;
import com.backend.services.DiscountService;

@Service
public class DiscountImpl implements DiscountService{

	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<Discount> getAllDiscount() {
		return discountRepository.findAll();
	}
	
	private List<DiscountDTO> convertToProductsDTO(List<Object[]> results) {
		List<DiscountDTO> DiscountDTOList = new ArrayList<>();

		for (Object[] result : results) {
			DiscountDTO DiscountDTO = new DiscountDTO();
			DiscountDTO.setPrice((BigDecimal) result[0]);
			DiscountDTO.setPricesale((BigDecimal) result[1]); 

			DiscountDTOList.add(DiscountDTO);
		}

		return DiscountDTOList;
	}

	public List<DiscountDTO> getDiscount(String id) {
		List<Object[]> results = discountRepository.getDiscount(id);
		return convertToProductsDTO(results);
	}
}
