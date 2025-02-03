package com.example.koschool.domain.quiz;

import com.example.koschool.domain.quiz.dto.response.LevelQuizResponseDto;
import com.example.koschool.domain.quiz.service.QuizService;
import com.example.koschool.global.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    /**
     * quiz level에 따른 랜덤 10문제 추출
     * @param level
     * @return
     */
    @GetMapping("/level")
    public ApiResponse<List<LevelQuizResponseDto>> levelQuiz(@RequestParam("level") String level) {
        return ApiResponse.of(HttpStatus.OK, quizService.levelQuiz(level));
    }
}
