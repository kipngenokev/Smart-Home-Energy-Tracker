package com.asanc.ingestion_service.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.Instant;


public record EnergyUsageDto (
    Long deviceId,
    double energyConsumed,
    @JsonFormat(shape = JsonFormat.Shape.STRING )
    Instant timeStamp) {}

