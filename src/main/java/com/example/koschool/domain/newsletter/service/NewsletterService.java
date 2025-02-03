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

    public NewsletterResponseDto getNewsLetter(String newsletterId) {
        System.out.println("asdfasdf");
        Optional<Newsletter> newsletter = newsletterRepository.findById(newsletterId);
        if(newsletter.isEmpty()){
            throw new CustomException(ErrorCode.NEWSLETTER_NOT_FOUND);
        }
        return NewsletterResponseDto.fromEntityToDto(newsletter.get());
    }
}
