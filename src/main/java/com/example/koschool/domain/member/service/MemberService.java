package com.example.koschool.domain.member.service;

import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import com.example.koschool.domain.member.dto.response.MemberResponseDto;
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
    public MemberResponseDto joinMember(JoinMemberRequestDto joinMemberRequestDto) {
        return MemberResponseDto.of(memberRepository.save(Member.fromDtoToEntity(joinMemberRequestDto)));
    }

    public MemberResponseDto loginMember(String id) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return MemberResponseDto.of(member);
    }
}
