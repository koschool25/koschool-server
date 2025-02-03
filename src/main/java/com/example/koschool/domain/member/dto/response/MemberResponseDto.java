package com.example.koschool.domain.member.dto.response;

import com.example.koschool.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;
    private String loginId;

    @Builder
    private MemberResponseDto(Long id, String loginId) {
        this.id = id;
        this.loginId = loginId;
    }

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
            .id(member.getId())
            .loginId(member.getLoginId())
            .build();
    }
}
