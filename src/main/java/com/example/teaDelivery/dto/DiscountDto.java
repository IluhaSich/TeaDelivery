package com.example.teaDelivery.dto;

import com.example.teaDelivery.entity.Client;
import com.example.teaDelivery.entity.PersonalDiscount;

public class DiscountDto {
    private Long personalDiscount;
    private Long client;

    public DiscountDto(Long personalDiscount, Long client) {
        this.personalDiscount = personalDiscount;
        this.client = client;
    }

    public Long getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(Long personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }
}
