package com.example.shop.service.impl;

import com.example.shop.dto.MonitorDto;
import com.example.shop.entity.Monitor;
import com.example.shop.mapper.MonitorMapper;
import com.example.shop.repository.MonitorRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements ProductService<MonitorDto> {

    private final MonitorMapper mapper;
    private final MonitorRepository monitorRepository;
    private final ModelMapper modelMapper;

    @Override
    public MonitorDto save(MonitorDto monitor) {
        Monitor savedMonitor = monitorRepository.save(mapper.toEntity(monitor));
        return mapper.toDto(savedMonitor);
    }

    @Override
    public MonitorDto update(MonitorDto monitorDto) {
        Monitor monitor = monitorRepository.findById(monitorDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Monitor not found with ID: " + monitorDto.getId()));
        modelMapper.map(monitorDto, monitor);
        return mapper.toDto(monitor);
    }

    @Override
    public List<MonitorDto> findAll() {
        return monitorRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public MonitorDto findById(Long id) {
        return mapper.toDto(monitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Monitor not found with ID: " + id)));
    }
}
