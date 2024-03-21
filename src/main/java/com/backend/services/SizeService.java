package com.backend.services;

import java.util.List;
import com.backend.dto.SizeDTO;
import com.backend.model.Size;

public interface SizeService {
	
	Object getAllSize(int page, int size);
	Object updateSize(String id, String size_no);
	Object searchSize(String sizeNo);

	Object getAllSize();
	List<SizeDTO> getSizeWhereId(String id);
}
