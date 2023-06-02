package com.example.shop.mapper;

import com.example.shop.dto.ComputerDto;
import com.example.shop.dto.MonitorDto;
import com.example.shop.entity.Computer;
import com.example.shop.entity.Monitor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonitorMapper implements com.example.shop.mapper.config.MonitorMapper<Monitor, MonitorDto> {

    private final ModelMapper mapper;

    @Override
    public Monitor toEntity(MonitorDto request) {
        return mapper.map(request, Monitor.class);
    }

    @Override
    public MonitorDto toDto(Monitor monitor) {
        return mapper.map(monitor, MonitorDto.class);
    }
}
