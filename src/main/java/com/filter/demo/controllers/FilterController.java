package com.filter.demo.controllers;

import com.filter.demo.entity.Consumer;
import com.filter.demo.service.ConsumerService;
import com.filter.demo.service.FilterService;
import com.filter.demo.service.OrderService;
import com.filter.demo.vo.FilterResponse;
import com.filter.demo.vo.FilterVO;
import com.filter.demo.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filter")
public class FilterController {

    private final ConsumerService consumerService;
    private final OrderService orderService;
    private final FilterService filterService;

    @PostMapping
    public List<FilterResponse> filterData(@RequestBody FilterVO request){
        return filterService.filterData(request);
    }

    @PostMapping("/create-consumer")
    public String createConsumer(@RequestBody Consumer consumer){
        consumerService.createConsumer(consumer);
        return "CREATED";
    }

    @PostMapping("/place-order")
    public String placeOrder(@RequestBody OrderVO request){
        orderService.placeOrder(request);
        return "ORDER_PLACED";
    }
}

