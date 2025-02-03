package com.example.koschool.domain.member;

import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import com.example.koschool.domain.member.dto.request.LoginMemberRequestDto;
import com.example.koschool.domain.member.dto.response.MemberResponseDto;
import com.example.koschool.domain.member.service.MemberService;
import com.example.koschool.global.ApiResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ApiResponse<MemberResponseDto> joinMember(@RequestBody JoinMemberRequestDto joinMemberRequestDto) {
        return ApiResponse.of(HttpStatus.CREATED, memberService.joinMember(joinMemberRequestDto));
    }

    @PostMapping("/login")
    public ApiResponse<MemberResponseDto> loginMember(@RequestBody LoginMemberRequestDto loginMemberRequestDto, HttpSession httpSession) {
        MemberResponseDto memberResponseDto = memberService.loginMember(loginMemberRequestDto.getLoginId());
        httpSession.setAttribute("id", loginMemberRequestDto.getId());
        return ApiResponse.of(HttpStatus.OK, memberResponseDto);
    }
}
