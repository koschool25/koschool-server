package com.example.koschool.domain.member.dto.response;

import com.example.koschool.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long memberId;
    private String loginId;

    @Builder
    private MemberResponseDto(Long memberId, String loginId) {
        this.memberId = memberId;
        this.loginId = loginId;
    }

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
            .memberId(member.getMemberId())
            .loginId(member.getLoginId())
            .build();
    }
}
