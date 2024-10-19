package com.circles24.service;

import com.circles24.constant.ExternalRecognitionStatus;
import com.circles24.dto.PaginationInfoDto;
import com.circles24.model.ExternalRecognition;
import com.circles24.repository.ExternalRecognitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalRecognitionService {

    private final ExternalRecognitionRepository externalRecognitionRepository;

    private static final int PAGE_SIZE = 5;

    public List<ExternalRecognition> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE, Sort.by("createdAt").descending());
        return externalRecognitionRepository.findAll(pageable);
    }

    public ExternalRecognition get(int id) {
        return externalRecognitionRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public ExternalRecognition create(ExternalRecognition externalRecognition) {
        externalRecognition.setStatus(ExternalRecognitionStatus.ACTIVE);
        return externalRecognitionRepository.save(externalRecognition);
    }

    public PaginationInfoDto getPaginationInfo() {
        long totalCount = externalRecognitionRepository.count();
        long pageCount = (totalCount + PAGE_SIZE - 1L) / PAGE_SIZE;

        return PaginationInfoDto.builder()
                .pageCount(pageCount)
                .pageSize(PAGE_SIZE)
                .build();
    }
}
