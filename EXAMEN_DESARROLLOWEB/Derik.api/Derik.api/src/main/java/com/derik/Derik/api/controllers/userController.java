package com.derik.Derik.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.derik.Derik.api.models.userModel;
import com.derik.Derik.api.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping ("/OW")

public class userController {


    @Autowired
    private userServices userServices;

    @GetMapping
    public ArrayList<userModel> getusers() { return this.userServices.getName();
    }

    @PostMapping
    public userModel saveUser(@RequestBody userModel user) {
        return this.userServices.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<userModel> getusersById(@PathVariable("id") long id){
        return this.userServices.getByID(id);
    }

    @PutMapping(path = "/{id}")
    public userModel updateuserbyid (@RequestBody userModel request,@PathVariable("id") long id){
        return this.userServices.updateById(request, id);
    }



    @DeleteMapping(path = "/{id}")
    public String eleteById(@PathVariable("id") Long id){
        boolean ok = this.userServices.deleteUser(id);

        if(ok){
            return "User with id " + id + " deleted!";
        } else {
            return "Error we have a problem and can't delete nose que el tipo del tutorial esta bloqueando la pantalla" + id; 
        }
    }
}
