package com.backend.services.servicesImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.SizeDTO;
import com.backend.model.Size;
import com.backend.repository.SizeRepository;
import com.backend.services.SizeService;

@Service
public class SizeImpl implements SizeService {

	@Autowired
	private SizeRepository sizeRepository;

	@Override
	public List<Size> getAllSize() {
		return sizeRepository.findAll(); 
	}

	private List<SizeDTO> convertToObjectDTO(List<Object[]> results) {
		List<SizeDTO> sizeDetailsDTOList = new ArrayList<>();

		for (Object[] result : results) {
			SizeDTO DetailsDTO = new SizeDTO();
			DetailsDTO.setId((String) result[0]);
			DetailsDTO.setSize_no((String) result[1]);
			DetailsDTO.setPrice(((BigDecimal) result[2]).intValue());

			sizeDetailsDTOList.add(DetailsDTO);
		}

		return sizeDetailsDTOList;
	}

	public List<SizeDTO> getSizeWhereId(String id) {
		List<Object[]> results = sizeRepository.findByIdWhere(id);
		return convertToObjectDTO(results);
	}
}
