package com.example.koschool.domain.newsletter;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.service.NewsletterService;
import com.example.koschool.global.ApiResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/newsletter")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @GetMapping("/")
    public ApiResponse<List<NewsletterListResponseDto>> getNewsLetterList(@RequestParam("category") String category,
        @RequestParam("date") LocalDate date) {
        return (ApiResponse<List<NewsletterListResponseDto>>) newsletterService.getNewsLetterList(category, date);
    }
}
