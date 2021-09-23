package com.SpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.entity.details;

@Repository
public interface HyberRepository extends JpaRepository<details, String>{

}
