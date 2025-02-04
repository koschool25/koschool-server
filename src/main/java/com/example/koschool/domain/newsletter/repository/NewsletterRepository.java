package com.example.koschool.domain.newsletter.repository;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.dto.response.NewsletterResponseDto;
import com.example.koschool.domain.newsletter.entity.Newsletter;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, String> {

    List<Newsletter> findTop3ByCategoryOrderByIdDesc(String category);

    List<Newsletter> findByCategoryAndDateOrderByLikesDesc(String category, LocalDate date);

    @Query("SELECT n FROM Newsletter n WHERE n.category = :category " +
        "AND n.date BETWEEN :startDate AND :endDate ORDER BY n.likes DESC")
    List<Newsletter> findTop3ByCategoryAndDateBetweenOrderByLikesDesc(@Param("category") String category,
        @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);

}
