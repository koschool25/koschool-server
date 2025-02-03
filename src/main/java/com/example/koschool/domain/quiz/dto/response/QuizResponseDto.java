package com.example.koschool.domain.quiz.dto.response;

import com.example.koschool.domain.quiz.entity.Quiz;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuizResponseDto {

    private Long id;
    private String question;
    private String answer;
    private String explanation;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    @Builder
    private QuizResponseDto(Long id, String question, String answer, String explanation, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }

    public static QuizResponseDto of(Quiz quiz) {
        return QuizResponseDto.builder()
            .id(quiz.getId())
            .question(quiz.getQuestion())
            .answer(quiz.getAnswer())
            .explanation(quiz.getExplanation())
            .wrongAnswer1(quiz.getWrongAnswer1())
            .wrongAnswer2(quiz.getWrongAnswer2())
            .wrongAnswer3(quiz.getWrongAnswer3())
            .build();
    }
}
