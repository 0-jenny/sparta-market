package com.sparta.market.controller;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.dto.MessageResponseDto;
import com.sparta.market.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class MarketController {
    //MemoController > MarketService > MemoRepository

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }
    //작성
    @PostMapping("/post")
    public MarketResponseDto createMarket(@RequestBody MarketRequestDto requestDto) {
        return marketService.createMarket(requestDto); //return 해서 바로 서비스로 보낸다

    }
    //조회
    @GetMapping("/post")
    public List<MarketResponseDto> getMarkets() {
        return marketService.getMarkets();

    }
    //조회
    @GetMapping("/post/content")
    public List<MarketResponseDto> getMarketsByKeyword(String keyword) {
        return marketService.getMarketsByKeyword(keyword);
    }
    //update
    @PutMapping("/post/{id}")
    public MarketResponseDto updateMarket(@PathVariable Long id, @RequestBody MarketRequestDto requestDto) {
        return marketService.updateMarket(id, requestDto);
    }
    //삭제
    @DeleteMapping("/post/{id}")
    public MessageResponseDto deleteMarket(@PathVariable Long id) {
        return marketService.deleteMarket(id);
    }

}