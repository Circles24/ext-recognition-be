package com.circles24.service;

import com.circles24.model.Media;
import lombok.RequiredArgsConstructor;
import com.circles24.repository.MediaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;

    public List<Media> getAllByRefTypeAndRefId(String refType, Integer refId) {
        return mediaRepository.findAllByRefTypeAndRefId(refType, refId);
    }

    public Media save(Media media) {
        return mediaRepository.save(media);
    }
}
