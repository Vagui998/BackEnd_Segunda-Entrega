package com.javeriana.proyecto.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.proyecto.Entities.Tool;

@RestController
@RequestMapping("/tools")
public class ToolCrudController extends AbstractCrudController<Tool>
{    
    public List<Tool> getAllTools()
    {
        return getAll();
    }

    public Tool getToolById(Long pId)
    {
        return getByID(pId);
    }

    public void newTool(@RequestBody Tool pEntity)
    {
        newEntry(pEntity);
    }

    public void updateTool(@RequestBody Tool pEntity) 
    {
        updateEntry(pEntity);
    }

    public void deleteTool(Long pId)
    {
        deleteEntry(pId);
    }
}
