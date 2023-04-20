package com.javeriana.proyecto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javeriana.proyecto.Entities.City;
import com.javeriana.proyecto.Entities.Tool;
import com.javeriana.proyecto.RelationEntities.ToolCity;
import com.javeriana.proyecto.RelationEntities.ToolCityId;

@Repository
interface ToolCityRepository extends CrudRepository<ToolCity, ToolCityId>
{
    @Query("SELECT tc.city FROM ToolCity tc WHERE tc.tool.id = :toolId")
    List<City> findCitiesByToolId(@Param("toolId") Long toolId);

    @Query("SELECT tc.tool FROM ToolCity tc WHERE tc.city.id = :cityId")
    List<Tool> findToolsByCityId(@Param("cityId") Long cityId);
}

@Service
public class ToolCityService
{
    @Autowired
    ToolCityRepository repo;

    public List<ToolCity> getAll()
    {
        return (List<ToolCity>) repo.findAll();
    }

    public List<City> getCitiesByTool(Long pId)
    {
        return repo.findCitiesByToolId(pId);
    }

    public List<Tool> getToolsByCity(Long pId)
    {
        return repo.findToolsByCityId(pId);
    }
}
