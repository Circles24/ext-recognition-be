package com.circles24.controller;

import com.circles24.model.Media;
import com.circles24.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/media")
public class MediaController {

    private final MediaService mediaService;

    @GetMapping
    public List<Media> getAllByRefTypeAndRefId(@RequestParam("refType") String refType,
                                               @RequestParam("refId") Integer refId) {
        return mediaService.getAllByRefTypeAndRefId(refType, refId);
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Media> createAll(@RequestParam("refType") String refType,
            @RequestParam("refId") Integer refId,
            @RequestParam("imageFiles") List<MultipartFile> imageFiles,
            @RequestParam("videoLinks") List<String> videoLinks) {
        return mediaService.createAll(refType, refId, imageFiles, videoLinks);
    }
}
