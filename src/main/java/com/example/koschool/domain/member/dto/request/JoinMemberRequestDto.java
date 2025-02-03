package com.example.koschool.domain.member.dto.request;

import com.example.koschool.domain.enums.CategoryEnum;
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
