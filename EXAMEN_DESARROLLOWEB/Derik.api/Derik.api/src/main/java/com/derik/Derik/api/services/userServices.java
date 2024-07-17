package com.derik.Derik.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derik.Derik.api.models.userModel;
import com.derik.Derik.api.repositories.userRepository;

@Service
public class userServices {
    @Autowired
    userRepository userRepository;

    public ArrayList<userModel> getName(){
        return (ArrayList<userModel>) userRepository.findAll();

    }
        public userModel saveUser(userModel user) {
            return userRepository.save(user);
        }


        public Optional<userModel> getByID(Long id){
            return userRepository.findById(id);
        }
    

    public userModel updateById(userModel request, Long id) {
        userModel user = userRepository.findById(id) .get();

        user.setName(request.getName());
        user.setnationality(request.getnationality());

        return user;
    }

    public Boolean deleteUser (long id) {
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



    }

    

