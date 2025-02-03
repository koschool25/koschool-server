package com.example.koschool.domain.quizHistory.dto.response;

import com.example.koschool.domain.quizHistory.dto.request.RegisterQuizHistoryRequestDto;
import com.example.koschool.domain.quizHistory.entity.QuizHistory;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterQuizHistoryResponseDto {

    private Long quizHistoryId;
    private Long id;
    private LocalDateTime date;
    private String rate;
    private String history;

    @Builder
    private RegisterQuizHistoryResponseDto(Long quizHistoryId, Long id, LocalDateTime date, String rate, String history) {
        this.quizHistoryId = quizHistoryId;
        this.id = id;
        this.date = date;
        this.rate = rate;
        this.history = history;
    }

    public static RegisterQuizHistoryResponseDto of(QuizHistory quizHistory) {
        return RegisterQuizHistoryResponseDto.builder()
            .quizHistoryId(quizHistory.getQuizHistoryId())
            .id(quizHistory.getMember().getId())
            .date(quizHistory.getDate())
            .rate(quizHistory.getRate())
            .history(quizHistory.getHistory())
            .build();
    }
}
