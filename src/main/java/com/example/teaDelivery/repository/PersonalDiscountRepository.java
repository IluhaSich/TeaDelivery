package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.PersonalDiscount;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDiscountRepository extends BaseRepository<PersonalDiscount,Long>{
//    PersonalDiscount getByDiscountName(String discountName);
}
