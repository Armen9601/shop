package com.example.shop.mapper.config;

import com.example.shop.entity.NoteBook;

public interface NoteBookMapper<Entity extends NoteBook, Dto> {

    Entity toEntity(Dto request);

    Dto toDto(Entity entity);
}