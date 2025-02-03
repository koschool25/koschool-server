package com.example.koschool.domain.member.service;

import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import com.example.koschool.domain.member.dto.response.MemberResponseDto;
import com.example.koschool.domain.member.entity.Member;
import com.example.koschool.domain.member.repository.MemberRepository;
import com.example.koschool.global.exception.CustomException;
import com.example.koschool.global.exception.ErrorCode;
import java.util.Optional;
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
        Optional<Member> member = memberRepository.findByLoginId(joinMemberRequestDto.getLoginId());
        if(member.isPresent()) {
            throw new CustomException(ErrorCode.MEMBER_LOGINID_DUPLICATED);
        }
        return MemberResponseDto.of(memberRepository.save(Member.fromDtoToEntity(joinMemberRequestDto)));
    }

    @Transactional
    public MemberResponseDto loginMember(String loginId) {
        Member member = memberRepository.findByLoginId(loginId)
            .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
        System.out.println("what");
        return MemberResponseDto.of(member);
    }
}
