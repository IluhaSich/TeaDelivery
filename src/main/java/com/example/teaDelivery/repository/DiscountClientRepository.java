package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.DiscountClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountClientRepository extends BaseRepository<DiscountClient,Long>{
//    List<DiscountClient> getByClient(Long clientId);
}
