package com.example.koschool.domain.community.dto.response;

import com.example.koschool.domain.community.entity.Community;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommunityListResponseDto {
    private Long communityId;
    private Long id;
    private String title;
    private Integer likes;
    private Integer comments;

    @Builder
    private CommunityListResponseDto(Long communityId, Long id, String title, Integer likes, Integer comments) {
        this.communityId = communityId;
        this.id = id;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
    }

    public static CommunityListResponseDto of(Community community) {
        return CommunityListResponseDto.builder()
            .communityId(community.getCommunityId())
            .id(community.getMember().getId())
            .title(community.getTitle())
            .likes(community.getLikes())
            .comments(community.getComments())
            .build();
    }

}
