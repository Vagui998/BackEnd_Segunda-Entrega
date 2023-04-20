package com.javeriana.proyecto.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name = "city")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class City extends AbstractEntity
{
    public City(Long pId, String pName)
    {
        super(pId, pName);
    }

    public City()
    {

    }
}
