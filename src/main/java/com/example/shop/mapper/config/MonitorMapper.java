package com.example.shop.mapper.config;

import com.example.shop.entity.Monitor;

public interface MonitorMapper<Entity extends Monitor, Dto> {

    Entity toEntity(Dto request);

    Dto toDto(Entity entity);
}