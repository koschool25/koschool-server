package com.example.koschool.domain.newsletter.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NewsletterListResponseDto {

    private Long newsletterId;
    private String title;

    @Builder
    private NewsletterListResponseDto(Long newsletterId, String title) {
        this.newsletterId = newsletterId;
        this.title = title;
    }

}
