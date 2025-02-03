package com.example.koschool.domain.quizHistory;

import com.example.koschool.domain.quizHistory.dto.request.RegisterQuizHistoryRequestDto;
import com.example.koschool.domain.quizHistory.dto.response.RegisterQuizHistoryResponseDto;
import com.example.koschool.domain.quizHistory.service.QuizHistoryService;
import com.example.koschool.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/history")
public class QuizHistoryController {
    private final QuizHistoryService quizHistoryService;

    @PostMapping("/wrong")
    public ApiResponse<RegisterQuizHistoryResponseDto> registerQuizHistory(@RequestBody RegisterQuizHistoryRequestDto registerQuizHistoryRequestDto) {
        return ApiResponse.of(HttpStatus.OK, quizHistoryService.registerQuizHistory(registerQuizHistoryRequestDto));
    }
}
