package com.javeriana.proyecto.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tool")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tool extends AbstractEntity
{
    @Setter
    @Getter
    @Column(name = "image_url")
    private String image_url;

    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "marca_id")
    private Brand brand;

    @Setter
    @Getter
    @Column(name = "precio")
    private double price;


    public Tool(Long pId, String pName, String pImgUrl, String pDescription, Brand pBrand, double pPrice) 
    {
        super(pId, pName);
        this.image_url = pImgUrl;
        this.description = pDescription;
        this.brand = pBrand;
        this.price = pPrice;
    }

    public Tool()
    {

    }
}
