package com.example.koschool.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.STRING)
public enum MessageEnum {

    RECEIVE("받은 메시지"),
    SEND("보낸 메시지");

    private final String type;

}
