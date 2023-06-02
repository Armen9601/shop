package com.example.shop.service.impl;

import com.example.shop.dto.NoteBookDto;
import com.example.shop.entity.NoteBook;
import com.example.shop.mapper.NoteBookMapper;
import com.example.shop.repository.NoteBookRepository;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteBookServiceImpl implements ProductService<NoteBookDto> {

    private final NoteBookMapper noteBookMapper;
    private final NoteBookRepository noteBookRepository;
    private final ModelMapper modelMapper;

    @Override
    public NoteBookDto save(NoteBookDto notebook) {
        NoteBook savedNotebook = noteBookRepository.save(noteBookMapper.toEntity(notebook));
        return noteBookMapper.toDto(savedNotebook);
    }

    @Override
    public NoteBookDto update(NoteBookDto noteBookDto) {
        NoteBook noteBook = noteBookRepository.findById(noteBookDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Notebook not found with ID: " + noteBookDto.getId()));
        modelMapper.map(noteBookDto, noteBook);
        return noteBookMapper.toDto(noteBook);
    }

    @Override
    public List<NoteBookDto> findAll() {
        return noteBookRepository.findAll().stream()
                .map(noteBookMapper::toDto)
                .toList();
    }

    @Override
    public NoteBookDto findById(Long id) {
        return noteBookMapper.toDto(noteBookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Notebook not found with ID: " + id)));
    }
}
