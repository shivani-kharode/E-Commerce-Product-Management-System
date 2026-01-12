package com.example.mapper;

import com.example.dto.request.OrdersDTORequest;
import com.example.dto.response.OrdersDTOResponse;
import com.example.entity.Orders;

public class OrdersMapper {
	
	public static Orders toEntity( OrdersDTORequest odr, double totalAmount) {
		
		Orders order = new Orders();
		order.setCustomerName(odr.getCustomerName());
		order.setOrderStatus("PENDING");
		order.setTotalAmount(totalAmount);
		return order;
	}
	
	public static OrdersDTOResponse toResponse( Orders order) {
		OrdersDTOResponse  dto = new OrdersDTOResponse();
		
		dto.setOrderId(order.getOrderId());
		dto.setCustomerName(order.getCustomerName());
		dto.setOrderStatus(order.getOrderStatus());
		dto.setTotalAmount(order.getTotalAmount());
		return dto;
	}

}
