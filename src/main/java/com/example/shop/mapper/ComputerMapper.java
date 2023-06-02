package com.example.shop.mapper;

import com.example.shop.dto.ComputerDto;
import com.example.shop.entity.Computer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ComputerMapper implements com.example.shop.mapper.config.ComputerMapper<Computer, ComputerDto> {

    private final ModelMapper mapper;

    @Override
    public Computer toEntity(ComputerDto request) {
        return mapper.map(request, Computer.class);
    }

    @Override
    public ComputerDto toDto(Computer computer) {
        return mapper.map(computer, ComputerDto.class);
    }
}
