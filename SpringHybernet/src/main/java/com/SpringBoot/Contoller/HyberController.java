package com.SpringBoot.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoot.Service.HyberService;
import com.SpringBoot.entity.details;



@Controller
public class HyberController {
	
	@Autowired
	HyberService service;
	
	@RequestMapping("/")
public String showlinkpage() {
	return "linkpage";
		
	}
	@RequestMapping("/viewCourseData")
	public String showCourseData(Model model) {
		List<details> couresList=service.couresData();
		model.addAttribute("courseData", couresList);
		return "coursedata";
		
	}
	@RequestMapping(value ="/savadata",method=RequestMethod.POST)
	public String savedataInDb(@RequestParam("id")String id,@RequestParam("coursename")String coursename ,@RequestParam("duration")String duration,@RequestParam("fee")String fee ) {
		details course = new details();
		course.setId(id);
		course.setCoursename(coursename);
		course.setDuration(duration);
		course.setFee(fee);
		service.savedataInDb(course);
		return "linkpage";
		
	}
	@RequestMapping("/SingleCourseData")
	public String singledata(@RequestParam("id")String id ,Model model) {
		details course=service.savedataInDb(id);
		model.addAttribute("courses", course);
		return "SingleCourseData";
		
	}
}

