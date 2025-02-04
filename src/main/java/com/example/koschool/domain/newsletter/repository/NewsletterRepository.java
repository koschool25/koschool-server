package com.example.koschool.domain.newsletter.repository;

import com.example.koschool.domain.newsletter.dto.response.NewsletterListResponseDto;
import com.example.koschool.domain.newsletter.dto.response.NewsletterResponseDto;
import com.example.koschool.domain.newsletter.entity.Newsletter;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, String> {

    List<Newsletter> findByCategoryAndDate(String category, LocalDate date);

    List<Newsletter> findByCategoryAndDateOrderByLikesDesc(String category, LocalDate date);

}
