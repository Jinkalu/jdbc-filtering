package com.filter.demo.service.impl;

import com.filter.demo.entity.Orders;
import com.filter.demo.repo.OrderRepo;
import com.filter.demo.service.OrderService;
import com.filter.demo.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public void placeOrder(OrderVO request) {
        orderRepo.save(Orders.builder()
                        .costumerId(request.getConsumerId())
                        .orderPlaced(LocalDate.now())
                .build());
    }
}
