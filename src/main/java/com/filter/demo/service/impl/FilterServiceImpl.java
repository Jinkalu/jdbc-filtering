package com.filter.demo.service.impl;

import com.filter.demo.service.FilterService;
import com.filter.demo.vo.FilterResponse;
import com.filter.demo.vo.FilterVO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
@Component
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public List<FilterResponse> filterData(FilterVO request) {
        String query = "select c.consumer_id,c.consumer_name," +
                "c.email,o.order_id,o.order_placed,o.order_id from consumer c join " +
                "orders o on c.consumer_id=o.costumer_id where 1=1";

        MapSqlParameterSource params = new MapSqlParameterSource();

        if (Objects.nonNull(request.getCostumer())) {
            if (PATTERN.matcher(request.getCostumer()).matches()) {
                params.addValue("consumerId", Integer.parseInt(request.getCostumer()));
                query += " AND c.consumer_id= :consumerId";
            } else {
                params.addValue("consumerName", request.getCostumer());
                query += " AND c.consumer_name ILIKE CONCAT('%',:consumerName,'%')";
            }
        }
        if (Objects.nonNull(request.getOrderId())) {
            params.addValue("orderId", request.getOrderId());
            query += " AND o.order_id= :orderId";
        }
        if (Objects.nonNull(request.getOrderDate())) {
            params.addValue("orderPlaced", request.getOrderDate());
            query += " AND o.order_placed= :orderPlaced";
        }
        return namedParameterJdbcTemplate.query(query, params, getConsumer());
    }

    private RowMapper<FilterResponse> getConsumer() {
        return (rs, rowNum) -> FilterResponse.builder()
                .consumerId(rs.getLong("consumer_id"))
                .consumerName(rs.getString("consumer_name"))
                .email(rs.getString("email"))
                .orderId(rs.getLong("order_id"))
                .orderPlaced(rs.getDate("order_placed"))
                .build();
    }
}
