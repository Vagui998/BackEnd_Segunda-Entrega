package com.javeriana.proyecto.RelationEntities;
import com.javeriana.proyecto.Interfaces.IRelationEntity;

import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class AbstractRelationEntity implements IRelationEntity
{
    public AbstractRelationEntity()
    {

    }

}
