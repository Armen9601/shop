package com.example.shop.controller;

import com.example.shop.dto.HardDiskDto;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hard-disks")
@RequiredArgsConstructor
public class HardDiskController {

    private final ProductService<HardDiskDto> hardDiskService;

    @PostMapping
    public ResponseEntity<HardDiskDto> createHardDisk(@RequestBody HardDiskDto hardDiskDto) {
        HardDiskDto createdHardDisk = hardDiskService.save(hardDiskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHardDisk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDiskDto> updateHardDisk(@PathVariable Long id, @RequestBody HardDiskDto hardDiskDto) {
        hardDiskDto.setId(id);
        HardDiskDto updatedHardDisk = hardDiskService.update(hardDiskDto);
        return ResponseEntity.ok(updatedHardDisk);
    }

    @GetMapping
    public ResponseEntity<List<HardDiskDto>> getAllHardDisks() {
        List<HardDiskDto> hardDisks = hardDiskService.findAll();
        return ResponseEntity.ok(hardDisks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDiskDto> getHardDiskById(@PathVariable Long id) {
        HardDiskDto hardDisk = hardDiskService.findById(id);
        return ResponseEntity.ok(hardDisk);
    }
}
