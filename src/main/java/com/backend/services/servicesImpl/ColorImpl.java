package com.backend.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.ColorDTO; 
import com.backend.model.Color;
import com.backend.repository.ColorRepository;
import com.backend.services.ColorService;

@Service
public class ColorImpl implements ColorService{
	
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public List<Color> getAllColor() {
		return colorRepository.findAll();
	}
	private List<ColorDTO> convertToObjectDTO(List<Object[]> results) {
		List<ColorDTO> ColorDTOList = new ArrayList<>();

		for (Object[] result : results) {
			ColorDTO ColorDTO = new ColorDTO();
			ColorDTO.setColor((String) result[0]); 
			ColorDTO.setNumberC((Integer) result[1]); 

			ColorDTOList.add(ColorDTO);
		}

		return ColorDTOList;
	}

	@Override
	public List<ColorDTO> getColorById(String id) {
		List<Object[]> results = colorRepository.getColorById(id);
		return convertToObjectDTO(results);
	}

}
