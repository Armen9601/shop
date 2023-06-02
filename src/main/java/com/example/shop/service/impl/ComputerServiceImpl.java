package com.example.shop.service.impl;

import com.example.shop.dto.ComputerDto;
import com.example.shop.entity.Computer;
import com.example.shop.mapper.ComputerMapper;
import com.example.shop.repository.ComputerRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier(value = "computerServiceImpl")
public class ComputerServiceImpl implements ProductService<ComputerDto> {

    private final ComputerMapper computerMapper;
    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;


    @Override
    public ComputerDto save(ComputerDto computerDto) {
        Computer savedComputer = computerRepository.save(computerMapper.toEntity(computerDto));
        return computerMapper.toDto(savedComputer);
    }

    @Override
    public ComputerDto update(ComputerDto computerDto) {
        Computer computer = computerRepository.findById(computerDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Computer not found with ID: " + computerDto.getId()));
        modelMapper.map(computerDto,computer);
        return computerMapper.toDto(computerRepository.save(computer));
    }

    @Override
    public List<ComputerDto> findAll() {
        return computerRepository.findAll().stream()
                .map(computerMapper::toDto)
                .toList();
    }

    @Override
    public ComputerDto findById(Long id) {
        return computerMapper.toDto(computerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Computer not found with ID: " + id)));
    }
}
