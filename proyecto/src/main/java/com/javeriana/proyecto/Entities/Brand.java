package com.javeriana.proyecto.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.InheritanceType;

@Entity
@Table(name = "brand")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Brand extends AbstractEntity
{
    @Setter
    @Getter
    @Column(name = "image_url")
    private String image_url;

    public Brand(Long pId, String pName, String pImgUrl)
    {
        super(pId, pName);
        this.image_url = pImgUrl;
    }

    public Brand()
    {
        
    }
}
