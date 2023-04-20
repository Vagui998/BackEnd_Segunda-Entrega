package com.javeriana.proyecto.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javeriana.proyecto.Entities.Tool;
import com.javeriana.proyecto.Interfaces.ICrudService;



@Repository
interface ToolRepository extends ICrudService.IEntityRepository<Tool> 
{

}

@Service
public class ToolCrudService implements ICrudService<Tool>
{




    @Autowired
    ToolRepository repo;

    public List<Tool> getAll()
    {
        return (List<Tool>) repo.findAll();
    }

    public Tool getByID(Long pId)
    {
        return repo.findById(pId).orElse(null);
    }

    public void newEntry(Tool pEntity)
    {
        repo.save(pEntity);
    }

    public void updateEntry(Tool pEntity)
    {
        Optional<Tool> targetEntity = repo.findById(pEntity.getID());
        if(targetEntity.isPresent())
        {
            System.out.println(pEntity.getImage_url());
            repo.save(pEntity);
        }
        else
        {
            System.out.println("The requested ID is not found");
        }
    }

    public void deleteEntry(Long pId)
    {
        Optional<Tool> targetEntity = repo.findById(pId);
        if(targetEntity.isPresent())
        {
            repo.delete(targetEntity.get());
        }
        else
        {
            System.out.println("The requested ID is not found");
        }
    }
    
}
