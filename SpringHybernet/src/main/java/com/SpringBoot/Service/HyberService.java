package com.SpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Repository.HyberRepository;
import com.SpringBoot.entity.details;

@Service
public class HyberService {
	@Autowired
	HyberRepository repository;
	public List<details> couresData() {
		List<details> couresList=repository.findAll();
		return couresList;
	}
	
	public void savedataInDb(details course) {
		repository.save(course);
	}
	public details savedataInDb(String id) {
		Optional<details> courseData=repository.findById(id);
		details courseobj=null;
		if(courseData.isPresent()) {
			courseobj = courseData.get();
		}
		return courseobj;
		
		
	}

}
