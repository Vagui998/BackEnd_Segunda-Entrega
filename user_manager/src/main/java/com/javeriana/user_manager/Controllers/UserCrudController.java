package com.javeriana.user_manager.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javeriana.user_manager.Entities.User;

import com.javeriana.user_manager.Services.UserCrudService;

@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('User')")
public class UserCrudController
{
    @Autowired
    UserCrudService service;

    @GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getAllUsers()
    {
        return service.getAll(); 
    }

    @GetMapping(value = "/{username}")
    public User getUserById(@PathVariable(value = "username") String pUsername)
    {
        return service.getByUsername(pUsername);
    }

    @PostMapping(value = "/newEntry")
    public void newTool(@RequestBody User pEntity)
    {
        service.newEntry(pEntity);
    }

    @PutMapping(value = "/updateEntry", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateTool(@RequestBody User pEntity) 
    {
        service.updateEntry(pEntity);
    }

    @DeleteMapping(value = "/deleteEntry/{id}")
    public void deleteTool(@PathVariable(value = "id") Integer pId)
    {
        service.deleteEntry(pId);
    } 
}
