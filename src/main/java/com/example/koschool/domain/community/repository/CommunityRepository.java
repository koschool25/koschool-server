package com.example.koschool.domain.community.repository;

import com.example.koschool.domain.community.dto.response.CommunityListResponseDto;
import com.example.koschool.domain.community.entity.Community;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, String> {

    @Query("SELECT NEW com.example.koschool.domain.community.dto.response.CommunityListResponseDto(c.communityId, c.member.memberId, c.title, c.likes, c.comments) "
        + "FROM Community c "
        + "ORDER BY c.createdAt DESC")
    Optional<List<CommunityListResponseDto>> findCommunity();

}
