package com.example.koschool.domain.newsletter.dto.response;

import com.example.koschool.domain.newsletter.entity.Newsletter;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NewsletterResponseDto {

    private String title;
    private String category;
    private String summary;
    private Integer likes;
    private String stock;
    private String link;

    @Builder
    private NewsletterResponseDto(String title, String category, String summary, Integer likes, String stock, String link) {
        this.title = title;
        this.category = category;
        this.summary = summary;
        this.likes = likes;
        this.stock = stock;
        this.link = link;
    }

    public static NewsletterResponseDto fromEntityToDto(Newsletter newsletter) {
        return NewsletterResponseDto.builder()
            .title(newsletter.getTitle())
            .category(newsletter.getCategory())
            .summary(newsletter.getSummary())
            .likes(newsletter.getLikes())
            .stock(newsletter.getStock())
            .link(newsletter.getLink())
            .build();
    }

}
