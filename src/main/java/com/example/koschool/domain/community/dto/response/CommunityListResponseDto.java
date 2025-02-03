package com.example.koschool.domain.community.dto.response;

import com.example.koschool.domain.community.entity.Community;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommunityListResponseDto {
    private Long communityId;
    private Long memberId;
    private String title;
    private Integer likes;
    private Integer comments;

    @Builder
    private CommunityListResponseDto(Long communityId, Long memberId, String title, Integer likes, Integer comments) {
        this.communityId = communityId;
        this.memberId = memberId;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
    }

    public static CommunityListResponseDto of(Community community) {
        return CommunityListResponseDto.builder()
            .communityId(community.getCommunityId())
            .memberId(community.getMember().getMemberId())
            .title(community.getTitle())
            .likes(community.getLikes())
            .comments(community.getComments())
            .build();
    }

}
