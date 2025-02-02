package com.example.koschool.domain.member.dto.response;

import com.example.koschool.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long memberId;
    private String id;

    @Builder
    private MemberResponseDto(Long memberId, String id) {
        this.memberId = memberId;
        this.id = id;
    }

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
            .memberId(member.getMemberId())
            .id(member.getId())
            .build();
    }
}
