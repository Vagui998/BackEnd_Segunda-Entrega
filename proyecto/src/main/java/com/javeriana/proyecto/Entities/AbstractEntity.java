package com.javeriana.proyecto.Entities;



import com.javeriana.proyecto.Interfaces.IEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public AbstractEntity(Long pId, String pName)
    {
        this.id = pId;
        this.name = pName;
    }

    public AbstractEntity()
    {
        
    }

    public void setName(String pName)
    {
        name = pName;
    }

    public String getName()
    {
        return name;
    }

    public Long getID()
    {
        return id;
    }

}
