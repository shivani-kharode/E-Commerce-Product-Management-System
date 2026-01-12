package com.example.mapper;

import com.example.dto.response.OrderItemDTOResponse;
import com.example.entity.OrderItem;

public class OrderItemMapper {
	
	public static OrderItemDTOResponse toResponse( OrderItem orderitem) {
		OrderItemDTOResponse dto = new OrderItemDTOResponse();
		dto.setOrderItemId(orderitem.getOrderItemId());
		dto.setProductName(orderitem.getProduct().getName());
		dto.setPrice(orderitem.getPrice());
		dto.setQuantity(orderitem.getQuantity());
		return dto;
	}

}
