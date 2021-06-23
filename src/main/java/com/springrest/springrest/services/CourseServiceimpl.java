package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	List<Course> list;
	
	public CourseServiceimpl() {
		
		list=new ArrayList<>();
		list.add(new Course(125,"Java","this is java course"));
		list.add(new Course(112,"Python","this is python course"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		
		Course c=null;
		for (Course course : list )
		{
			if (course.getId() == courseId)
			{
				c = course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}
	
	public Course updateCourse(Course course)
	{
		list.forEach(e ->{
			if (e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}
}
