package com.example.shop.mapper;

import com.example.shop.dto.ComputerDto;
import com.example.shop.dto.HardDiskDto;
import com.example.shop.entity.Computer;
import com.example.shop.entity.HardDisk;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HardDiskMapper implements com.example.shop.mapper.config.HardDiskMapper<HardDisk, HardDiskDto> {

    private final ModelMapper mapper;

    @Override
    public HardDisk toEntity(HardDiskDto request) {
        return mapper.map(request, HardDisk.class);
    }

    @Override
    public HardDiskDto toDto(HardDisk hardDisk) {
        return mapper.map(hardDisk, HardDiskDto.class);
    }
}
