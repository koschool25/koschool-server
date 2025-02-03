package com.example.koschool.domain.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinMemberRequestDto {

    private String loginId;
    private String password;
    private String categoryTopic;

}
