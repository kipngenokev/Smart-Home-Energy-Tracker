package com.asanc.device_service.controller;

import com.asanc.device_service.dto.DeviceDto;
import com.asanc.device_service.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController (DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {
        DeviceDto device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

}
