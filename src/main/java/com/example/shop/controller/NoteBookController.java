package com.example.shop.controller;

import com.example.shop.dto.NoteBookDto;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notebooks")
@RequiredArgsConstructor
public class NoteBookController {

    private final ProductService<NoteBookDto> noteBookService;

    @PostMapping
    public ResponseEntity<NoteBookDto> createNoteBook(@RequestBody NoteBookDto noteBookDto) {
        NoteBookDto createdNoteBook = noteBookService.save(noteBookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNoteBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteBookDto> updateNoteBook(@PathVariable Long id, @RequestBody NoteBookDto noteBookDto) {
        noteBookDto.setId(id);
        NoteBookDto updatedNoteBook = noteBookService.update(noteBookDto);
        return ResponseEntity.ok(updatedNoteBook);
    }

    @GetMapping
    public ResponseEntity<List<NoteBookDto>> getAllNoteBooks() {
        List<NoteBookDto> noteBooks = noteBookService.findAll();
        return ResponseEntity.ok(noteBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteBookDto> getNoteBookById(@PathVariable Long id) {
        NoteBookDto noteBook = noteBookService.findById(id);
        return ResponseEntity.ok(noteBook);
    }
}
