package com.example.koschool.domain.community;

import com.example.koschool.domain.community.dto.response.CommunityListResponseDto;
import com.example.koschool.domain.community.service.CommunityService;
import com.example.koschool.domain.communityLikes.dto.request.CommunityLikesRequestDto;
import com.example.koschool.domain.communityLikes.dto.response.CommunityLikesResponseDto;
import com.example.koschool.global.ApiResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/list")
    public ApiResponse<List<CommunityListResponseDto>> getCommunityList() {
        return ApiResponse.of(HttpStatus.OK, communityService.getCommunityList());
    }
}
