package com.example.koschool.domain.community.service;

import com.example.koschool.domain.community.dto.response.CommunityListResponseDto;
import com.example.koschool.domain.community.entity.Community;
import com.example.koschool.domain.community.repository.CommunityRepository;
import com.example.koschool.domain.communityLikes.dto.request.CommunityLikesRequestDto;
import com.example.koschool.domain.communityLikes.dto.response.CommunityLikesResponseDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityService {

    private final CommunityRepository communityRepository;

    public List<CommunityListResponseDto> getCommunityList() {
        Optional<List<CommunityListResponseDto>> communityListResponseDto = communityRepository.findCommunity();
        return communityListResponseDto.orElseGet(null);
    }
}
