package com.example.koschool.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.STRING)
public enum LevelEnum {

    BEGINNER("하수"),
    INTERMEDIATE("중수"),
    EXPERT("고수");

    private final String level;

    public static LevelEnum ofLevelEnum(String value) {
        return Arrays.stream(LevelEnum.values())
            .filter(v -> v.getLevel().equals(value))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레벨입니다."));
    }
}
