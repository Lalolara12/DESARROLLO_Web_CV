package com.derik.Derik.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derik.Derik.api.models.userModel;


@Repository
public interface userRepository extends JpaRepository<userModel, Long>{
    
}
