package com.javeriana.proyecto.RelationEntities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ToolCityId extends AbstractId
{

    @Setter
    @Getter
    @Column(name = "tool_id")
    private Long toolId;

    @Setter
    @Getter
    @Column(name = "city_id")
    private Long cityId;

    public ToolCityId(Long pToolId, Long pCityId)
    {
        super();
        this.cityId = pCityId;
        this.toolId = pToolId; 
    }

    public ToolCityId()
    {
        super();
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(toolId, cityId);
    }

    @Override
    public boolean equals(Object obj)
     {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ToolCityId other = (ToolCityId) obj;
        return Objects.equals(toolId, other.cityId) &&
                Objects.equals(toolId, other.cityId);
    }

    @Override
    public Long getId0() 
    {
        return this.toolId;
    }

    @Override
    public Long getId1() 
    {
        return this.cityId;
    }
}