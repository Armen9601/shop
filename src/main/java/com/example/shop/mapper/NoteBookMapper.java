package com.example.shop.mapper;

import com.example.shop.dto.ComputerDto;
import com.example.shop.dto.NoteBookDto;
import com.example.shop.entity.Computer;
import com.example.shop.entity.NoteBook;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NoteBookMapper implements com.example.shop.mapper.config.NoteBookMapper<NoteBook, NoteBookDto> {

    private final ModelMapper mapper;

    @Override
    public NoteBook toEntity(NoteBookDto request) {
        return mapper.map(request, NoteBook.class);
    }

    @Override
    public NoteBookDto toDto(NoteBook noteBook) {
        return mapper.map(noteBook, NoteBookDto.class);
    }
}
