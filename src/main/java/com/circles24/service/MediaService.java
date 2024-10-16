package com.circles24.service;

import com.circles24.constant.ExternalRecognitionMediaStatus;
import com.circles24.constant.ExternalRecognitionMediaType;
import com.circles24.model.Media;
import lombok.RequiredArgsConstructor;
import com.circles24.repository.MediaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Media> createAll(String refType, Integer refId, List<MultipartFile> imageFiles,
                                 List<String> videoLinks) {
        List<Media> mediaList = new ArrayList<>();
        imageFiles.forEach(imgFile -> {
            try {
                String extension = "";
                String fileName = imgFile.getOriginalFilename();
                if (Objects.nonNull(fileName)) {
                    String[] splits = fileName.split("\\.");
                    if (splits.length > 0) {
                        extension = splits[splits.length - 1];
                    }
                }

                Media media = Media.builder()
                        .refId(refId)
                        .refType(refType)
                        .type(ExternalRecognitionMediaType.IMAGE)
                        .mediaContent(imgFile.getBytes())
                        .fileName(fileName)
                        .fileExtension(extension)
                        .mimeType(imgFile.getContentType())
                        .status(ExternalRecognitionMediaStatus.ACTIVE)
                        .build();
                media = save(media);
                mediaList.add(media);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        videoLinks.forEach(videoLink -> {
            Media media = Media.builder()
                    .refId(refId)
                    .refType(refType)
                    .type(ExternalRecognitionMediaType.VIDEO)
                    .mediaUrl(videoLink)
                    .status(ExternalRecognitionMediaStatus.ACTIVE)
                    .build();
            media = save(media);
            mediaList.add(media);
        });

        return mediaList;
    }
}
