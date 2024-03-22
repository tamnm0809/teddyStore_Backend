package com.backend.services;

import java.util.List;

import com.backend.dto.DetailOrd;
import com.backend.model.DetailsOrder;

public interface DetailsOrderService {

	public List<DetailsOrder> getAllDetailsOrder();

<<<<<<< HEAD
	public DetailsOrder addNewDetailOrder(DetailsOrder detailsOrder);
=======
    public List<DetailOrd> getAllDetailsOrders();
>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1
}
