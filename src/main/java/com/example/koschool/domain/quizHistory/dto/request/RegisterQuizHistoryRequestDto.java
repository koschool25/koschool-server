package com.example.koschool.domain.quizHistory.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterQuizHistoryRequestDto {

    private Long id;
    private String rate;
    private String history;
}
