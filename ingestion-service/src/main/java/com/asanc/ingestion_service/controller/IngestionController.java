package com.asanc.ingestion_service.controller;

import com.asanc.ingestion_service.dtos.EnergyUsageDto;
import com.asanc.ingestion_service.service.IngestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ingestion")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void ingestData(@RequestBody EnergyUsageDto usageDto) {
        ingestionService.ingestEnergyUsage(usageDto);
    }
}
