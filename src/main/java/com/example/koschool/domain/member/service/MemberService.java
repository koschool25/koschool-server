package com.example.koschool.domain.member.service;

import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import com.example.koschool.domain.member.dto.response.JoinMemberResponseDto;
import com.example.koschool.domain.member.entity.Member;
import com.example.koschool.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public JoinMemberResponseDto saveMember(JoinMemberRequestDto joinMemberRequestDto) {
        return JoinMemberResponseDto.of(memberRepository.save(Member.fromDtoToEntity(joinMemberRequestDto)));
    }
}
