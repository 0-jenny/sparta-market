package com.sparta.market.repository;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market>findAllByOrderByModifiedAtDesc();
    List<Market> findAllByContentContainsOrderByModifiedAtDesc(String keyword);

}
