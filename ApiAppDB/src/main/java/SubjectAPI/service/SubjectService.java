package CoursesAPI.service;

import CoursesAPI.DTO.Course;
import CoursesAPI.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {


    @Autowired
    private CourseRepository CourseRepository;

    //defining the list of Topics to perform add, delete and update operations
    private List<Course> courses = new ArrayList<>();

    //function to get all the courses displayed
    public List<Course> getAllCourses()
    {
        return courses;
//        List<Course> course = new ArrayList<>();
//        CourseRepository.findAll() //iterating over all the course in database
//        .forEach(course::add);
//        return course;
    }

    //function to get a single topic through id
    public Course getCourse(String topicId)
    {
        return courses.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
//        return CourseRepository.findById(topicId).get();

    }

    //function to add a course of Course type to the list
    public String addCourse(Course course)
    {
        courses.add(course);
        return "addition of the course is done";
//        CourseRepository.save(course);
    }

    //function to update a particular course using id
    public void updateCourse(Course course, String id)
    {
        for(int i=0;i<courses.size();i++)
        {
            //comparison
            if(courses.get(i).getId().toString().equals(id) )
            {
                courses.set(i,course);
                return;
            }
        }

//        CourseRepository.save(course);
    }

    //function to delete a particular course using id
    public void deleteCourse(Course course, String id)
    {

        courses.removeIf(t-> t.getId().equals(id));
//        CourseRepository.delete(course);
    }


}
