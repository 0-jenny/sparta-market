package com.sparta.market.entity;
import com.sparta.market.dto.MarketRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "Item") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Market extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "content" , nullable = false, length = 500)
    private String content;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "title", nullable = false, length = 100)
    private String title;


    public Market(MarketRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.title = requestDto.getTitle();
    }

    public void update(MarketRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.price = requestDto.getPrice();
        this.title = requestDto.getTitle();
    }


}