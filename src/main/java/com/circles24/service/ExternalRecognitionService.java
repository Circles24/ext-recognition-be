package com.circles24.service;

import com.circles24.constant.ExternalRecognitionStatus;
import com.circles24.model.ExternalRecognition;
import com.circles24.repository.ExternalRecognitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalRecognitionService {

    private final ExternalRecognitionRepository externalRecognitionRepository;

    public List<ExternalRecognition> list() {
        return externalRecognitionRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public ExternalRecognition create(ExternalRecognition externalRecognition) {
        externalRecognition.setStatus(ExternalRecognitionStatus.ACTIVE);
        return externalRecognitionRepository.save(externalRecognition);
    }
}
