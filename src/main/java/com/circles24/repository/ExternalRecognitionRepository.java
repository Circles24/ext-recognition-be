package com.circles24.repository;

import com.circles24.model.ExternalRecognition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExternalRecognitionRepository extends CrudRepository<ExternalRecognition, Integer> {
    List<ExternalRecognition> findAll(Pageable pageable);
}
