package com.backend.services.servicesImpl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.dto.CartDTO;
import com.backend.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.repository.CartRepository;
import com.backend.services.CartService;

@Service
public class CartImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	private List<CartDTO> convertToObjectDTO(List<Object[]> results) {
		List<CartDTO> cartDetailsDTOList = new ArrayList<>();

		for (Object[] result : results) {
			CartDTO DetailsDTO = new CartDTO();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			DetailsDTO.setId_acc((String) result[0]);
			DetailsDTO.setId((String) result[1]);
			DetailsDTO.setPrice_pro(((BigDecimal) result[2]).intValue());
			DetailsDTO.setName_ser((String) result[3]);
			DetailsDTO.setName_pro((String) result[4]);
			DetailsDTO.setColor((String) result[5]);
			DetailsDTO.setPrice_ser(((BigDecimal) result[6]).intValue());
			DetailsDTO.setSize_no((String) result[7]);
			DetailsDTO.setQuantity_pro((Integer) result[8]);
			DetailsDTO.setQuantity_ser((Integer) result[9]);
			DetailsDTO.setDate_add((Date) result[10]);
			DetailsDTO.setImage_pro((String) result[11]);

			cartDetailsDTOList.add(DetailsDTO);
		}

		return cartDetailsDTOList;
	}
	@Override
	public List<CartDTO> getAllCart(String id) {
		List<Object[]> results = cartRepository.findAllBy(id);
		return convertToObjectDTO(results);
	}

	@Override
	public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

}
