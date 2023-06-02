package com.example.shop.controller;

import com.example.shop.dto.ComputerDto;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Qualifier("computerServiceImpl")
    @Autowired
    private ProductService<ComputerDto> productService;

    @PostMapping
    public ResponseEntity<ComputerDto> createComputer(@RequestBody ComputerDto computerDto) {
        ComputerDto savedComputer = productService.save(computerDto);
        return new ResponseEntity<>(savedComputer, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ComputerDto> updateComputer(@PathVariable Long id, @RequestBody ComputerDto computerDto) {
        computerDto.setId(id);
        ComputerDto updatedComputer = productService.update(computerDto);
        return new ResponseEntity<>(updatedComputer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ComputerDto>> getAllComputers() {
        List<ComputerDto> computers = productService.findAll();
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerDto> getComputerById(@PathVariable Long id) {
        ComputerDto computer = productService.findById(id);
        return new ResponseEntity<>(computer, HttpStatus.OK);
    }
}
