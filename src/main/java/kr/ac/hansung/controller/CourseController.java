package kr.ac.hansung.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/searchCredits")
	public String showCredits(Model model) {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int semester;
		
		// 이번학기
		if(3<= month && month<=8) { // 현재 1학기
			semester = 1;
		}
		else { // 현재 2학기
			if(month==1 || month==2) {
				year = year - 1;
			}
			semester = 2;
		}
		
		List<Course> courses = courseService.getCreditsBySemester(year, semester);
		model.addAttribute("courses", courses);
		
		return "searchCredits";
	}
	
	@RequestMapping(value={"/searchCourses", "/searchApplyCourse"})
	public String showCourses(Model model, HttpServletRequest request, @RequestParam("year") int year, @RequestParam("semester")int semester) {
		String requestUrl = (String)request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		List<Course> courses = courseService.getCoursesBySemester(year, semester);
		model.addAttribute("courses", courses);
		
		return requestUrl;
	}
	
	@RequestMapping("/applyCourse")
	public String applyCourse(Model model) {
		
		model.addAttribute("course", new Course());
		
		return "applyCourse";
	}
	
	@RequestMapping("/doCreate")
	public String doCreate(Model model, @Valid Course course, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("== Form data does not validated ==");
			
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "applyCourse";
		}
		
		courseService.insert(course);
		
		return "courseCreated";
	}
}
