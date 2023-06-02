package com.example.shop.repository;

import com.example.shop.entity.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteBookRepository extends JpaRepository<NoteBook, Long> {
}
