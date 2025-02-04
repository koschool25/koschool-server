package com.example.koschool.domain.newsletter;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.dto.response.NewsletterResponseDto;
import com.example.koschool.domain.newsletter.service.NewsletterService;
import com.example.koschool.global.ApiResponse;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/newsletter")
public class NewsletterController {

    private final NewsletterService newsletterService;

    /**
     * 뉴스레터 핫토픽 목록 보기
     * @param category
     * @param date
     * @return
     */
    @GetMapping("/list")
    public ApiResponse<List<NewsletterListResponseDto>> getNewsletterList(@RequestParam("category") String category,
        @RequestParam("date") LocalDate date) {
        return ApiResponse.of(HttpStatus.OK, newsletterService.getNewsLetterList(category, date));
    }

    /**
     * 뉴스레터 핫토픽 랭킹 보기
     * @param category
     * @param date
     * @return
     */
    @GetMapping("/list/likes")
    public ApiResponse<List<NewsletterListResponseDto>> getNewsletterListWithLikes(@RequestParam("category") String category,
        @RequestParam("date") LocalDate date) {
        return ApiResponse.of(HttpStatus.OK, newsletterService.getNewsLetterListWithLikes(category, date));
    }

    @GetMapping("/detail")
    public ApiResponse<NewsletterResponseDto> getNewsletter(@RequestParam("newsletterId") String newsletterId) {
        return ApiResponse.of(HttpStatus.OK, newsletterService.getNewsLetter(newsletterId));
    }
}
