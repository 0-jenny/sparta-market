package com.sparta.market.service;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;

import com.sparta.market.dto.MessageResponseDto;
import com.sparta.market.entity.Market;
import com.sparta.market.repository.MarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;



    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createMarket(MarketRequestDto requestDto) {
        // RequestDto -> Entity
        Market market = new Market(requestDto);

        // DB 저장
        Market saveMarket = marketRepository.save(market);

        // Entity -> ResponseDto로 반환
        MarketResponseDto marketResponseDto = new MarketResponseDto(market);

        return marketResponseDto;


    }

    public List<MarketResponseDto> getMarkets() {
        // DB 조회
        return marketRepository.findAllByOrderByModifiedAtDesc().stream().map((Market market) -> new MarketResponseDto(market)).toList();

    }
    @Transactional // 변경 금지를 위해
    public MarketResponseDto updateMarket(Long id, MarketRequestDto requestDto) {

        //해당 메모가 DB에 존재하는지 확인
        Market market = findMarket(id);
        // market 내용 수정
        market.update(requestDto);
        return new MarketResponseDto(market);

    }

    public MessageResponseDto deleteMarket(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Market market = findMarket(id);
        //market 삭제
        marketRepository.delete(market);
//        return new MarketResponseDto(market);
        return new MessageResponseDto("삭제완료");
//        return msg;

    }
    public List<MarketResponseDto> getMarketsByKeyword(String keyword) {
        return marketRepository.findAllByContentContainsOrderByModifiedAtDesc(keyword).stream().map((Market market) -> new MarketResponseDto(market)).toList();
    }

    private Market findMarket(Long id) {
        return marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );

    }
}
