package com.sparta.market.dto;

import com.sparta.market.entity.Market;
import lombok.Getter;

@Getter
public class MarketResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private Integer price;

    public MarketResponseDto(Market market) {
        this.id = market.getId();
        this.username = market.getUsername();
        this.title = market.getTitle();
        this.content = market.getContent();
        this.price = market.getPrice();

    }

}