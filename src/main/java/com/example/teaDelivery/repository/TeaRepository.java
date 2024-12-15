package com.example.teaDelivery.repository;

import com.example.teaDelivery.entity.Tea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<Tea> findAll(Pageable pageable);
    Page<Tea> findByNameContainingIgnoreCaseAndSortContainingIgnoreCaseAndCostGreaterThanAndCostLessThan
            (String name,String sort,int startCost, int endCost,Pageable pageable);
}
