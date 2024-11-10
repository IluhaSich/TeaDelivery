package com.example.teaDelivery.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends Repository<T,ID> {
    <S extends T> S save(S entity);
    Optional<T> getById(Long id);
    List<T> findAll();
}
