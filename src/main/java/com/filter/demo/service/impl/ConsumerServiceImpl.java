package com.filter.demo.service.impl;

import com.filter.demo.entity.Consumer;
import com.filter.demo.repo.ConsumerRepo;
import com.filter.demo.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    public final ConsumerRepo consumerRepo;

    @Override
    public void createConsumer(Consumer consumer) {
        consumerRepo.save(consumer);
    }
}
