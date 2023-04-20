package com.javeriana.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.proyecto.Entities.City;
import com.javeriana.proyecto.Entities.Tool;
import com.javeriana.proyecto.RelationEntities.ToolCity;
import com.javeriana.proyecto.Services.ToolCityService;

@RestController
@RequestMapping("/toolCity")
public class ToolCityController
{
    @Autowired
    private ToolCityService service;

    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ToolCity> getAll()
    {
        return service.getAll();  
    }

    @GetMapping(value = "/getCities/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<City> getCitiesByTool(@PathVariable(value = "id") Long pId)
    {
        return service.getCitiesByTool(pId);
    }

    @GetMapping(value = "/getTools/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Tool> getToolsByCity(@PathVariable(value = "id") Long pId)
    {
        return service.getToolsByCity(pId);
    }
}
