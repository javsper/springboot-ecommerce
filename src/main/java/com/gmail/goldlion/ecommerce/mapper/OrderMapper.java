package com.gmail.goldlion.ecommerce.mapper;

import com.gmail.goldlion.ecommerce.domain.Order;
import com.gmail.goldlion.ecommerce.dto.order.OrderRequestDto;
import com.gmail.goldlion.ecommerce.dto.order.OrderResponseDto;
import com.gmail.goldlion.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final ModelMapper modelMapper;
    private final OrderService orderService;

    private Order convertToEntity(OrderRequestDto orderRequestDto) {
        return modelMapper.map(orderRequestDto, Order.class);
    }

    private OrderResponseDto convertToResponseDto(Order order) {
        return modelMapper.map(order, OrderResponseDto.class);
    }

    private List<OrderResponseDto> convertListToResponseDto(List<Order> orders) {
        return orders.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> findAllOrders() {
        return convertListToResponseDto(orderService.findAll());
    }

    public List<OrderResponseDto> findOrderByEmail(String email) {
        return convertListToResponseDto(orderService.findOrderByEmail(email));
    }

    public List<OrderResponseDto> deleteOrder(Long orderId) {
        return convertListToResponseDto(orderService.deleteOrder(orderId));
    }

    public OrderResponseDto postOrder(OrderRequestDto orderRequestDto) {
        return convertToResponseDto(orderService.postOrder(convertToEntity(orderRequestDto), orderRequestDto.getPerfumesId()));
    }
}
