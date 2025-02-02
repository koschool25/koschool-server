package com.example.koschool.domain.member.dto.response;

import com.example.koschool.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinMemberResponseDto {

    private Long memberId;
    private String id;

    @Builder
    private JoinMemberResponseDto(Long memberId, String id) {
        this.memberId = memberId;
        this.id = id;
    }

    public static JoinMemberResponseDto of(Member member) {
        return JoinMemberResponseDto.builder()
            .memberId(member.getMemberId())
            .id(member.getId())
            .build();
    }
}
