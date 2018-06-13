package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
	@Resource
	CourseRepository courseRepo;

	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) // model part of spring framework
	{
		// building out model called courses
		model.addAttribute("courses", courseRepo.findAll()); // adding attributes by attribute name (model name) and
																// value which is everything you want to show in
																// template
		return "courses";
		// create a model called courses and this will be the reference that
		// is needed for thymeleaf template
		// find all the courses that we have and be able to run the functionality to
		// pull them out

	}

	@RequestMapping("/course") // matching template had to be created in bash touch course.html
	public String findOneCourse(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("courses", courseRepo.findOne(id));
		return "course";
	}
	//
	// @RequestMapping("/course")
	// public String findOneCourse(@RequestParam(value = "id") Long id, Model model)
	// {
	// model.addAttribute("courses", courseRepo.findOne(id));
	// return "course";
	// //need to have a request parameter of ID, that's how it knows to
	// //differentiate one view from the other in template
	// }
}
