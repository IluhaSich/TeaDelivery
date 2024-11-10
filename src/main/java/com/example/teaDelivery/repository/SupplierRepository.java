package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.BaseEntity;
import com.example.teaDelivery.entity.Supplier;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends BaseRepository<Supplier,Long> {
}
