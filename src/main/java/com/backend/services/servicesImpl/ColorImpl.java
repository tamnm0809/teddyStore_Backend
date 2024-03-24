package com.backend.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.dto.ColorDTO; 
import com.backend.model.Color;
import com.backend.repository.ColorRepository;
import com.backend.services.ColorService;
import com.backend.util.RandomUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorImpl implements ColorService{

	private final ColorRepository colorRepository;
//	@Autowired
//	private ColorRepository colorRepository;

	@Override
	public Object getAllColor(int page, int size) {
		var pageable = PageRequest.of(page, size);
		return colorRepository.findAll(pageable);
	}

	@Override
	public Object updateColor(String id, String color) {
		var colorEntity = colorRepository.findById(id);
		if(colorEntity.isPresent()) {
			var colorUpdate = colorEntity.get();
			colorUpdate.setColor(color);
			colorRepository.save(colorUpdate);
		} else {
			var colorNew = new Color();
			var lastColor = colorRepository.findLastColor();
			if(lastColor.isPresent()) {
				colorNew.setId(RandomUtil.getNextId(lastColor.get().getId(),"CO"));
			} else {
				colorNew.setId(RandomUtil.getNextId(null,"CO"));
			}
			colorNew.setColor(color);
			colorRepository.save(colorNew);
		}
		return "OK";
	}

	@Override
	public Object searchColor(String color) {
		return colorRepository.findAllByName(color, PageRequest.of(0, 10));
	}

	@Override
	public Object getAllColor() {
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
