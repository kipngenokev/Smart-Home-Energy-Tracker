package com.asanc.device_service.repository;

import com.asanc.device_service.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
}
