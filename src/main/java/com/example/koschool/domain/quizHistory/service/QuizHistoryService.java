package com.example.koschool.domain.quizHistory.service;

import com.example.koschool.domain.member.entity.Member;
import com.example.koschool.domain.member.repository.MemberRepository;
import com.example.koschool.domain.quizHistory.dto.request.RegisterQuizHistoryRequestDto;
import com.example.koschool.domain.quizHistory.dto.response.RegisterQuizHistoryResponseDto;
import com.example.koschool.domain.quizHistory.entity.QuizHistory;
import com.example.koschool.domain.quizHistory.repository.QuizHistoryRepository;
import com.example.koschool.global.exception.CustomException;
import com.example.koschool.global.exception.ErrorCode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class QuizHistoryService {

    private final QuizHistoryRepository quizHistoryRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public RegisterQuizHistoryResponseDto registerQuizHistory(RegisterQuizHistoryRequestDto registerQuizHistoryRequestDto) {
        Member member = memberRepository.findById(String.valueOf(registerQuizHistoryRequestDto.getId()))
            .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        QuizHistory quizHistory = QuizHistory.builder()
            .member(member)
            .date(LocalDateTime.now())
            .rate(registerQuizHistoryRequestDto.getRate())
            .history(registerQuizHistoryRequestDto.getHistory())
            .build();

        return RegisterQuizHistoryResponseDto.of(quizHistoryRepository.save(quizHistory));
    }

}
