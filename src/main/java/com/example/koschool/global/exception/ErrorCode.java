package com.example.koschool.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MEMBER_LOGINID_DUPLICATED("이미 존재하는 아이디입니다."),
    MEMBER_NOT_FOUND("존재하지 않는 회원입니다."),

    NEWSLETTER_NOT_FOUND("존재하지 않는 뉴스레터입니다.");

    private final String message;
}
