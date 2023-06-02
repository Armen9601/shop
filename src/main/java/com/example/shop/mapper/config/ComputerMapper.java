package com.example.shop.mapper.config;

import com.example.shop.entity.Computer;

public interface ComputerMapper<Entity extends Computer, Dto> {

    Entity toEntity(Dto request);

    Dto toDto(Entity entity);
}