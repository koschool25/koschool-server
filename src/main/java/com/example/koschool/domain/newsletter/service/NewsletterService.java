package com.example.koschool.domain.newsletter.service;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.dto.response.NewsletterResponseDto;
import com.example.koschool.domain.newsletter.entity.Newsletter;
import com.example.koschool.domain.newsletter.repository.NewsletterRepository;
import com.example.koschool.global.exception.CustomException;
import com.example.koschool.global.exception.ErrorCode;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class NewsletterService {

    private final NewsletterRepository newsletterRepository;

    public List<NewsletterListResponseDto> getNewsletterList(String category) {
        List<Newsletter> newsletters = newsletterRepository.findTop3ByCategoryOrderByIdDesc(category);
        return newsletters.stream()
            .map(newsletter -> new NewsletterListResponseDto(newsletter.getId(), newsletter.getTitle()))
            .collect(Collectors.toList());
    }

    public List<NewsletterListResponseDto> getNewsletterListWithLikes(String category, LocalDate date) {
        Pageable pageable = PageRequest.of(0, 3);
        List<Newsletter> newsletters = newsletterRepository.findTop3ByCategoryAndDateBetweenOrderByLikesDesc(
            category, date.minusMonths(1), date, pageable);
        return newsletters.stream()
            .map(newsletter -> new NewsletterListResponseDto(newsletter.getId(), newsletter.getTitle()))
            .collect(Collectors.toList());
    }

    public List<NewsletterListResponseDto> getNewsletterListPrevious(String category) {
        List<Newsletter> newsletters = newsletterRepository.findAllByCategoryOrderByIdDesc(category);
        return newsletters.stream()
            .map(newsletter -> new NewsletterListResponseDto(newsletter.getId(), newsletter.getTitle()))
            .collect(Collectors.toList());
    }

    public NewsletterResponseDto getNewsLetterDetail(Long newsletterId) {
        Newsletter newsletter = newsletterRepository.findById(newsletterId)
            .orElseThrow(() -> new CustomException(ErrorCode.NEWSLETTER_NOT_FOUND));
        return NewsletterResponseDto.fromEntityToDto(newsletter);
    }
}
