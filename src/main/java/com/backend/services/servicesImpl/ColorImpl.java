package com.backend.services.servicesImpl;

import java.util.List;

import com.backend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.model.Color;
import com.backend.repository.ColorRepository;
import com.backend.services.ColorService;

@Service
@RequiredArgsConstructor
public class ColorImpl implements ColorService{
	
	private final ColorRepository colorRepository;

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

}
