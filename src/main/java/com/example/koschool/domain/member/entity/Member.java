package com.example.koschool.domain.member.entity;

import com.example.koschool.domain.community.entity.Community;
import com.example.koschool.domain.enums.CategoryEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", unique = true, nullable = false)
    private Long memberId;

    /**
     * 사용자 id
     */
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    /**
     * 사용자 pw
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 사용자 뉴스레터 취향
     */
    @Column(name = "category_topic", nullable = false)
    private CategoryEnum categoryTopic;

    /**
     * 커뮤니티
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Community> communityList;

}
