package com.circles24.controller;

import com.circles24.dto.PaginationInfoDto;
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
    public List<ExternalRecognition> list(@RequestParam("page") int page) {
        return externalRecognitionService.list(page);
    }

    @GetMapping("/{id}")
    public ExternalRecognition list(@PathVariable("id") Integer id) {
        return externalRecognitionService.get(id);
    }

    @PostMapping()
    public ExternalRecognition create(@RequestBody ExternalRecognition externalRecognition) {
        return externalRecognitionService.create(externalRecognition);
    }

    @GetMapping("/pagination-info")
    public PaginationInfoDto getPaginationInfo() {
        return externalRecognitionService.getPaginationInfo();
    }

    @GetMapping("/top-interacted")
    public List<ExternalRecognition> getTopInteractedRecognitions() {
        return externalRecognitionService.getTopInteractedRecognitions();
    }
}
