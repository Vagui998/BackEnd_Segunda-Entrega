package com.javeriana.user_manager.Services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javeriana.user_manager.Entities.Role;
import com.javeriana.user_manager.Entities.User;

import com.javeriana.user_manager.Repos.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCrudService 
{
    @Autowired
    UserRepository repo;

    private final PasswordEncoder passwordEncoder;

    public List<User> getAll()
    {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = authenticatedUser.getAuthorities().toArray()[0].toString();
        if(role.equals(Role.Admin.name()))
        {
            return (List<User>) repo.findAll();
        }
        else
        {
            return null;
        }
    }

    public User getByUsername(String pUsername)
    {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> targetEntity = repo.findByUsername(pUsername);
        String role = authenticatedUser.getAuthorities().toArray()[0].toString();
        if (targetEntity.isPresent() && ((role.equals(Role.Admin.name()) || targetEntity.get().getId() == authenticatedUser.getId())))
        { 
            return targetEntity.get();       
        } 
        else 
        {
            return null;
        }
    }

    public void newEntry(User pEntity)
    {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = authenticatedUser.getAuthorities().toArray()[0].toString();
        if(role.equals(Role.Admin.name()))
        {
            pEntity.setPassword(passwordEncoder.encode(pEntity.getPassword()));
            repo.save(pEntity);
        }
        else
        {
            
        }  
    }

    public void updateEntry(User pEntity)
    {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> targetEntity = repo.findById(pEntity.getId());
        String role = authenticatedUser.getAuthorities().toArray()[0].toString();
        if(targetEntity.isPresent() && role.equals(Role.Admin.name()))
        {
            pEntity.setPassword(passwordEncoder.encode(pEntity.getPassword()));
            repo.save(pEntity);
        }
        else
        {
            System.out.println("The requested ID is not found or you don't have permission to update it.");
        }
    }

    public void deleteEntry(Integer pId)
    {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> targetEntity = repo.findById(pId);
        String role = authenticatedUser.getAuthorities().toArray()[0].toString();
        if(targetEntity.isPresent() && role.equals(Role.Admin.name()))
        {
            repo.delete(targetEntity.get());
        }
        else
        {
            System.out.println("The requested ID is not found or you don't have permission to delete it.");
        }
    }

}

