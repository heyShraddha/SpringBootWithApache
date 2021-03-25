package CoursesAPI.controller;

import CoursesAPI.DTO.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CoursesAPI.service.CourseService CourseService;

    public CourseController(CoursesAPI.service.CourseService CourseService) {
        this.CourseService = CourseService;
    }

    //Display all the values
    @RequestMapping("/courses")
    public List<Course> getAllCourses()
    {
        return CourseService.getAllCourses();
    }

    //Display a single entity
    @RequestMapping("/topics/{id}/courses")
    public Course getCourse(@PathVariable String id)
    {
        return CourseService.getCourse(id);
    }





    //Insert Operation
    @RequestMapping(method = RequestMethod.POST,value ="/courses")
    public void addCourse(@RequestBody Course course)
    {
        CourseService.addCourse(course);
    }
    //update operation
    @RequestMapping(method = RequestMethod.PUT,value ="/topics/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id )
    {
        CourseService.updateCourse(course,id);
    }




    
    //delete operation
    @RequestMapping(method = RequestMethod.DELETE,value ="/courses/{id}")
    public void deleteCourse(@RequestBody Course course, @PathVariable String id )
    {
        CourseService.deleteCourse(course,id);
    }
}
