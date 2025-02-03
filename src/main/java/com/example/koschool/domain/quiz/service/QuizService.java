package com.example.koschool.domain.quiz.service;

import com.example.koschool.domain.quiz.dto.response.QuizResponseDto;
import com.example.koschool.domain.quiz.entity.Quiz;
import com.example.koschool.domain.quiz.repository.QuizRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuizService {

    private final QuizRepository quizRepository;

    public List<QuizResponseDto> levelQuiz(String level) {
        Pageable pageable = PageRequest.of(0, 10);
        List<Quiz> quizList = quizRepository.findRandomQuizzesByLevel(level, pageable);
        return quizList.stream()
            .map(QuizResponseDto::of)
            .collect(Collectors.toList());
    }

    public List<QuizResponseDto> newsletterQuiz(String newsletter) {
        List<Long> newsletterIdList = Arrays.stream(newsletter.split(","))
            .map(Long::parseLong)
            .collect(Collectors.toList());

        List<Quiz> quizList = quizRepository.findQuizzesByNewsletterIds(newsletterIdList);

        return quizList.stream()
            .map(QuizResponseDto::of)
            .collect(Collectors.toList());
    }
}
