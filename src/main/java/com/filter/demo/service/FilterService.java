package com.filter.demo.service;

import com.filter.demo.vo.FilterResponse;
import com.filter.demo.vo.FilterVO;

import java.util.List;

public interface FilterService {
    List<FilterResponse> filterData(FilterVO request);
}
