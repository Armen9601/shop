package com.example.shop.mapper.config;

import com.example.shop.entity.Computer;
import com.example.shop.entity.HardDisk;

public interface HardDiskMapper<Entity extends HardDisk, Dto> {

    Entity toEntity(Dto request);

    Dto toDto(Entity entity);
}