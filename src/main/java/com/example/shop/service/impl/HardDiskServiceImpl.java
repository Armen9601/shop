package com.example.shop.service.impl;

import com.example.shop.dto.HardDiskDto;
import com.example.shop.entity.HardDisk;
import com.example.shop.mapper.HardDiskMapper;
import com.example.shop.repository.HardDiskRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HardDiskServiceImpl implements ProductService<HardDiskDto> {

    private final HardDiskMapper hardDiskMapper;
    private final HardDiskRepository hardDiskRepository;
    private final ModelMapper modelMapper;

    @Override
    public HardDiskDto save(HardDiskDto hardDisk) {
        HardDisk savedDisk = hardDiskRepository.save(hardDiskMapper.toEntity(hardDisk));
        return hardDiskMapper.toDto(savedDisk);
    }

    @Override
    public HardDiskDto update(HardDiskDto hardDiskDto) {
        HardDisk hardDisk = hardDiskRepository.findById(hardDiskDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("HardDidk not found with ID: " + hardDiskDto.getId()));
        modelMapper.map(hardDiskDto, hardDisk);
        return hardDiskMapper.toDto(hardDiskRepository.save(hardDisk));
    }

    @Override
    public List<HardDiskDto> findAll() {
        return hardDiskRepository.findAll().stream()
                .map(hardDiskMapper::toDto)
                .toList();
    }

    @Override
    public HardDiskDto findById(Long id) {
        return hardDiskMapper.toDto(hardDiskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("HardDisk not found with ID: " + id)));
    }
}
