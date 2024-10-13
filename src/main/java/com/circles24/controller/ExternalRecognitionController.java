package com.circles24.controller;

import com.circles24.model.ExternalRecognition;
import com.circles24.service.ExternalRecognitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external-recognition")
public class ExternalRecognitionController {

    private final ExternalRecognitionService externalRecognitionService;

    @GetMapping()
    public List<ExternalRecognition> list() {
        return externalRecognitionService.list();
    }

    @PostMapping()
    public ExternalRecognition create(@RequestBody ExternalRecognition externalRecognition) {
        return externalRecognitionService.create(externalRecognition);
    }
}
