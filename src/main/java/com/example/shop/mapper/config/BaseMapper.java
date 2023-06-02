package com.example.shop.mapper.config;

public interface BaseMapper<Entity, Dto> {

  Entity toEntity(Dto request);

  Dto toDto(Entity entity);
}
