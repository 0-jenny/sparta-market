package com.sparta.market.dto;

import com.sparta.market.entity.Market;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MarketRequestDto {
    private String username;
    private String content;
    private Integer price;
    private String title;

    public MarketRequestDto(Market market) {
        this.username = market.getUsername();
        this.content = market.getContent();
        this.title = market.getTitle();
        this.price = market.getPrice();
    }


}