package com.sparta.market.dto;


import lombok.Getter;

@Getter
public class MessageResponseDto {
    private String msg;

    public MessageResponseDto(String msg) {
        this.msg = msg;
    }

}
