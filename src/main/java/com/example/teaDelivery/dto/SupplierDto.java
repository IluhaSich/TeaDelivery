package com.example.teaDelivery.dto;

public class SupplierDto {
    private String supplier_name;
    private String email;

    public SupplierDto(String supplier_name, String email) {
        this.supplier_name = supplier_name;
        this.email = email;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
