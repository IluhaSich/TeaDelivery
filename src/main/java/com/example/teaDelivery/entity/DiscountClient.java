package com.example.teaDelivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discount_client")
public class DiscountClient extends BaseEntity{
    private PersonalDiscount personalDiscount;
    private Client client;

    @ManyToOne
    @JoinColumn(name = "personal_discount_id")
    public PersonalDiscount getPersonalDiscount() {
        return personalDiscount;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setPersonalDiscount(PersonalDiscount personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
