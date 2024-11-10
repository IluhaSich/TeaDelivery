package com.example.teaDelivery.service;

public interface BaseService<EntityDto,Entity> {
    EntityDto convertToDto(Entity entity);
}
