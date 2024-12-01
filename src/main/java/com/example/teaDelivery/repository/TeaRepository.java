package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Tea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaRepository extends BaseRepository<Tea,Long>{
    List<Tea> getBySort(String sort);
    Tea getByName(String name);
    List<Tea> getByAvailability(boolean availability);
    @Query("SELECT DISTINCT t.sort FROM Tea t")
    List<String> findAllDistinctSort();
}
