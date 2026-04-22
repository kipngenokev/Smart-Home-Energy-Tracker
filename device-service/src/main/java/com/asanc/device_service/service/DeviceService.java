package com.asanc.device_service.service;

import com.asanc.device_service.dto.DeviceDto;
import com.asanc.device_service.entity.Device;
import com.asanc.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Device not found with id "+id));
        return mapToDto(device);
    }

    private DeviceDto mapToDto(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setId(device.getId());
        dto.setName(device.getName());
        dto.setType(device.getType());
        dto.setLocation(device.getLocation());
        dto.setUserId(device.getUserId());
        return dto;
    }
}
