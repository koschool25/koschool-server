package com.example.koschool.domain.newsletter.service;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.repository.NewsletterRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class NewsletterService {

    private final NewsletterRepository newsletterRepository;

    public List<NewsletterListResponseDto> getNewsLetterList(String category, LocalDate date) {
        return newsletterRepository.findByCategoryAndDate(category, date);
    }
}
