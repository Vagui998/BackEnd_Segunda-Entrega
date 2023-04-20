package com.javeriana.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.proyecto.Entities.AbstractEntity;
import com.javeriana.proyecto.Interfaces.ICrudController;
import com.javeriana.proyecto.Interfaces.ICrudService;

import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public abstract class AbstractCrudController <T extends AbstractEntity> implements ICrudController<T>
{
    @Autowired
    protected ICrudService<T> service;
  
    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<T> getAll()
    {
        return service.getAll();  
    }

    @GetMapping(value = "/{id}")
    public T getByID(@PathVariable(value = "id") Long pId)
    {
        return service.getByID(pId);
    }

    @PostMapping(value = "/newEntry")
    public void newEntry(@RequestBody T pEntity)
    {
        service.newEntry(pEntity);
    }

    @PutMapping(value = "/updateEntry", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateEntry(@RequestBody T pEntity) 
    {
        service.updateEntry(pEntity);
    }

    @DeleteMapping(value = "/deleteEntry/{id}")
    public void deleteEntry(@PathVariable(value = "id") Long pId)
    {
        service.deleteEntry(pId);
    }
}
