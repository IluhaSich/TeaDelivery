package com.example.teaDelivery.dto;

public class SupplierDto extends BaseDto{
    private String supplier_name;
    private String email;

    public SupplierDto(Long id,String supplier_name, String email) {
        setId(id);
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
