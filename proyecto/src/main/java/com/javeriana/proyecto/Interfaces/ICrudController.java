package com.javeriana.proyecto.Interfaces;

import java.util.List;


import com.javeriana.proyecto.Entities.AbstractEntity;

public interface ICrudController<T extends AbstractEntity>
{
    public List<T> getAll();
    public T getByID(Long pId);
    public void newEntry(T pEntity);
    public void updateEntry(T pEntity);
    public void deleteEntry(Long pId);
}