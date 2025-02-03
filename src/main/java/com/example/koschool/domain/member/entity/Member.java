package com.example.koschool.domain.member.entity;

import com.example.koschool.domain.member.dto.request.JoinMemberRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /**
     * 사용자 id
     */
    @Column(name = "login_id", unique = true, nullable = false)
    private String loginId;

    /**
     * 사용자 pw
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 사용자 뉴스레터 취향
     */
    @Column(name = "category_topic", nullable = false)
    private String categoryTopic;

    @Builder
    private Member(String loginId, String password, String categoryTopic) {
        this.loginId = loginId;
        this.password = password;
        this.categoryTopic = categoryTopic;
    }

    public static Member fromDtoToEntity(JoinMemberRequestDto memberRequestDto) {
        return Member.builder()
            .loginId(memberRequestDto.getLoginId())
            .password(memberRequestDto.getPassword())
            .categoryTopic(memberRequestDto.getCategoryTopic())
            .build();
    }

}
