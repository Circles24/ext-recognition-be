package com.circles24.repository;

import com.circles24.model.Media;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface MediaRepository extends CrudRepository<Media, Integer> {
    List<Media> findAllByRefTypeAndRefId(String refType, Integer refId);
}
