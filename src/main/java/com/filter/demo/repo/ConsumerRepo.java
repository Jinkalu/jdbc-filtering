package com.filter.demo.repo;

import com.filter.demo.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer,Long> {
    Consumer findByConsumerName(String username);
}
