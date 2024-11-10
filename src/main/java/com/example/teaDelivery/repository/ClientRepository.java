package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client,Long>{
//    Client getByEmail(String email);
}
