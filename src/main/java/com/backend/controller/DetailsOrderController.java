//package com.backend.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD
//import org.springframework.web.bind.annotation.*;
//=======
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1
//
//import com.backend.dto.DetailOrd; 
//import com.backend.model.DetailsOrder;
//import com.backend.services.DetailsOrderService;
//
//@RestController
//@RequestMapping("/teddy-store")
//<<<<<<< HEAD
//@CrossOrigin(value = "http://localhost:3000/")
//public class DetailsOrderController {
//
//    @Autowired
//    private DetailsOrderService detailsOrderService;
//
//    @GetMapping("/getAllDetailsOrder")
//    public List<DetailsOrder> getAllDetailsOrder() {
//        return detailsOrderService.getAllDetailsOrder();
//    }
//
//    @PostMapping("/addNewOrderDetail")
//    public DetailsOrder addNewOrderDetail(@RequestBody DetailsOrder detailsOrder) {
//        return detailsOrderService.addNewDetailOrder(detailsOrder);
//    }
//=======
//@CrossOrigin(value="http://localhost:3000/")
//public class DetailsOrderController {
//
//	@Autowired
//	private DetailsOrderService detailsOrderService;
//	
//	@GetMapping("/getAllDetailsOrder")
//	public List<DetailsOrder> getAllDetailsOrder(){
//		return detailsOrderService.getAllDetailsOrder();
//		
//	}@GetMapping("/DetailsOrders")
//	public List<DetailOrd> getAllDetailsOrders(){
//		return detailsOrderService.getAllDetailsOrders();
//	}
//>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1
//}
