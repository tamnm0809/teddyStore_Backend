package com.backend.services.servicesImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.DetailOrd; 
import com.backend.model.DetailsOrder;
import com.backend.repository.DetailsOrderRepository;
import com.backend.services.DetailsOrderService;

@Service
public class DetailsOrderImpl implements DetailsOrderService{
	
	@Autowired
	private DetailsOrderRepository detailsOrderRepository;

	@Override
	public List<DetailsOrder> getAllDetailsOrder() {
		return detailsOrderRepository.findAll();
	}
	private List<DetailOrd> convertToObjectDTO(List<Object[]> results) {
		List<DetailOrd> DetailsOrdDTOList = new ArrayList<>();

		for (Object[] result : results) {
			DetailOrd DetailsOrdDTO = new DetailOrd();
			DetailsOrdDTO.setDate((Date) result[0]);
			DetailsOrdDTO.setId((String) result[1]);
			DetailsOrdDTO.setStatus((String) result[2]);
			DetailsOrdDTO.setPrice_unit((BigDecimal) result[3]); 

			DetailsOrdDTOList.add(DetailsOrdDTO);
		}

		return DetailsOrdDTOList;
	}


	public List<DetailOrd> getAllDetailsOrders() {
		List<Object[]> results = detailsOrderRepository.getLatestOrderss();
		return convertToObjectDTO(results);
	}
	 
	 


}
