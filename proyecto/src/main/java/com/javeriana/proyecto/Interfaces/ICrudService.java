package com.javeriana.proyecto.Interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javeriana.proyecto.Entities.AbstractEntity;

public interface ICrudService <T extends AbstractEntity>
{
    interface IEntityRepository<T extends AbstractEntity> extends CrudRepository<T, Long>
    {
        
    }

    List<T> getAll();
    T getByID(Long id);
    void newEntry(T entity);
    void updateEntry(T entity);
    void deleteEntry(Long id);
}
