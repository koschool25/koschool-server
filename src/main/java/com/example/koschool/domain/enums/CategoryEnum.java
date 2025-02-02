package com.example.koschool.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum CategoryEnum {

    RECHARGEABLE_BATTERY("2차전지"),
    SEMICONDUCTOR("반도체");

    private final String name;

    public static CategoryEnum ofCategoryEnum(String value) {
        return Arrays.stream(CategoryEnum.values())
            .filter(v -> v.getName().equals(value))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 토픽입니다."));
    }
}