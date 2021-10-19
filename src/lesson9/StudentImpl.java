package lesson9;

import lesson9.interfaces.Course;
import lesson9.interfaces.Student;

import java.util.Arrays;
import java.util.List;

public class StudentImpl implements Student {
    private String name;
    private List<Course> courses;

    public StudentImpl(String name, Course... courses) {
        this.name = name;
        this.courses = Arrays.asList(courses);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
