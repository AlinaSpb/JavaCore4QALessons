package lesson9;

import lesson9.interfaces.Course;
import lesson9.interfaces.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны
 * студенты.
 * <p>
 * 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
 * (любознательность определяется количеством курсов).
 * <p>
 * 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые
 * посещают этот курс.
 */
public class Lesson9 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new StudentImpl("Ваня",
                                new CourseImpl(1),
                                new CourseImpl(2),
                                new CourseImpl(3)
                        ),
                        new StudentImpl("Петя",
                                new CourseImpl(4),
                                new CourseImpl(2),
                                new CourseImpl(3)
                        ),
                        new StudentImpl("Маша",
                                new CourseImpl(1),
                                new CourseImpl(2),
                                new CourseImpl(3),
                                new CourseImpl(4),
                                new CourseImpl(5)
                        ),
                        new StudentImpl("Таня",
                                new CourseImpl(1),
                                new CourseImpl(2),
                                new CourseImpl(4),
                                new CourseImpl(5)
                        ),
                        new StudentImpl("Вася",
                                new CourseImpl(4),
                                new CourseImpl(3)
                        )
                )
        );

        System.out.println("Задание 1");
        List<Course> uniqueCourses = getStudentCourses(students);
        uniqueCourses.forEach(course -> System.out.println(((CourseImpl) course).getCourseId()));

        System.out.println("Задание 2");
        List<Student> topStudents = getTopStudents(students);
        topStudents.forEach(student -> System.out.println(student.getName()));

        System.out.println("Задание 3");
        List<Student> studentsByCourse = getStudentsByCourse(students, new CourseImpl(5));
        studentsByCourse.forEach(student -> System.out.println(student.getName()));
    }

    /**
     * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны *
     * студенты.
     *
     * @return
     */
    public static List<Course> getStudentCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных *
     * (любознательность определяется количеством курсов).
     */
    public static List<Student> getTopStudents(List<Student> students) {
        return students.stream()
                .sorted((s2, s1) -> Integer.compare(s1.getAllCourses().size(), s2.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов,
     * которые * посещают этот курс.
     */
    public static List<Student> getStudentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
