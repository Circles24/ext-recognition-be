package com.circles24.repository;

import com.circles24.model.Media;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends CrudRepository<Media, Integer> {
    List<Media> findAllByRefTypeAndRefId(String refType, Integer refId);
}
