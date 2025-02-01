package com.example.koschool.domain.session.entity;

import com.example.koschool.domain.common.BaseEntity;
import com.example.koschool.domain.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "Session")
public class Session extends BaseEntity {

    /**
     * 고유 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id", unique = true, nullable = false)
    private Long sessionId;

    /**
     * 사용자 고유 id
     */
    @ManyToOne
    @JoinColumn(referencedColumnName = "member_id", name = "member_id", nullable = false)
    private Member member;

    /**
     * AI가 요약한 세션 이름
     */
    @Column(name = "session_name", nullable = false)
    private String sessionName;
}
