package com.example.shop.controller;

import com.example.shop.dto.MonitorDto;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
@RequiredArgsConstructor
public class MonitorController {

    private final ProductService<MonitorDto> monitorService;

    @PostMapping
    public ResponseEntity<MonitorDto> createMonitor(@RequestBody MonitorDto monitorDto) {
        MonitorDto createdMonitor = monitorService.save(monitorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorDto> updateMonitor(@PathVariable Long id, @RequestBody MonitorDto monitorDto) {
        monitorDto.setId(id);
        MonitorDto updatedMonitor = monitorService.update(monitorDto);
        return ResponseEntity.ok(updatedMonitor);
    }

    @GetMapping
    public ResponseEntity<List<MonitorDto>> getAllMonitors() {
        List<MonitorDto> monitors = monitorService.findAll();
        return ResponseEntity.ok(monitors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDto> getMonitorById(@PathVariable Long id) {
        MonitorDto monitor = monitorService.findById(id);
        return ResponseEntity.ok(monitor);
    }
}
