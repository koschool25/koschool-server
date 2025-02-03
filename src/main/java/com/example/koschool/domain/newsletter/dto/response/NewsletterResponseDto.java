package com.example.koschool.domain.newsletter.dto.response;

import com.example.koschool.domain.newsletter.entity.Newsletter;
import java.util.Random;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NewsletterResponseDto {
    private String title;
    private String summary;
    private Integer likes;
    private String stock;
    private String link;

    Random random = new Random();

    @Builder
    private NewsletterResponseDto(String title, String summary, Integer likes, String stock, String link) {
        this.title = title;
        this.summary = summary;
        this.likes = random.nextInt(240)+11;
        this.stock = stock;
        this.link = link;
    }

    public static NewsletterResponseDto fromEntityToDto(Newsletter newsletter) {
        return NewsletterResponseDto.builder()
            .title(newsletter.getTitle())
            .summary(newsletter.getSummary())
            .likes(newsletter.getLikes())
            .stock(newsletter.getStock())
            .link(newsletter.getLink())
            .build();
    }

}
