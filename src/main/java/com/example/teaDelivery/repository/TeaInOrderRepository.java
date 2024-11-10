package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Tea;
import com.example.teaDelivery.entity.TeaInOrder;
import com.example.teaDelivery.entity.TeaOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaInOrderRepository extends BaseRepository<TeaInOrder,Long>{
//    List<TeaInOrder> getByTeaOrder(TeaOrder teaOrder);
//    List<TeaInOrder> getByTea(Tea tea);
}
