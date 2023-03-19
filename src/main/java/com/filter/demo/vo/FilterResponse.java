package com.filter.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterResponse {
    private Long consumerId;
    private String consumerName;
    private String email;
    private Long orderId;
    private Date orderPlaced;
}
