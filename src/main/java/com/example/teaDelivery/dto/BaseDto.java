package com.example.teaDelivery.dto;

import jakarta.persistence.*;

public abstract class BaseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
