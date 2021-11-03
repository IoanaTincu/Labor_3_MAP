package repository;

import exceptions.NullValueException;
import model.Course;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    CourseRepository courseRepo = new CourseRepository();

    List<Course> listCourses1 = new ArrayList<>();
    List<Student> listStudents1 = new ArrayList<>();
    Teacher teacher1 = new Teacher(52, "Mugur", "Acu", listCourses1);
    Teacher teacher2 = new Teacher(11, "Mugur", "Acu", listCourses1);
    Course course1 = new Course(653, "Analiza matematica", teacher1, 48, listStudents1, 6);
    Course course2 = new Course(1226, "Algoritmi fundamentali", teacher2, 27, listStudents1, 3);

    @BeforeEach
    public void setUp() {
        try {
            courseRepo.save(course1);
        } catch (NullValueException e) {
        }
    }

    @org.junit.jupiter.api.Test
    void findOne() {
        try {
            assertEquals(courseRepo.findOne(course1.getId()), course1);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.findOne(course2.getId()), null);
        } catch (NullValueException e) {
        }

        try {
            courseRepo.findOne(null);
            assert (false);
        } catch (NullValueException e) {
        }
    }

    @org.junit.jupiter.api.Test
    void save() {
        try {
            assertEquals(courseRepo.save(course2), null);
        } catch (NullValueException e) {
        }

        assertEquals(courseRepo.size(), 2);
        try {
            assertEquals(courseRepo.findOne(course2.getId()), course2);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.save(course2), course2);
        } catch (NullValueException e) {
        }

        try {
            courseRepo.save(null);
            assert (false);
        } catch (NullValueException e) {
        }
    }

    @org.junit.jupiter.api.Test
    void delete() {
        try {
            courseRepo.delete(null);
            assert (false);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.delete(course2.getId()), null);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.delete(course1.getId()), course1);
        } catch (NullValueException e) {
        }

        assertEquals(courseRepo.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void update() {
        Course newCourse1 = new Course(653, "Analiza matematica", teacher1, 48, listStudents1, 6);

        try {
            assertEquals(courseRepo.update(newCourse1), null);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.findOne(newCourse1.getId()), newCourse1);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(courseRepo.update(course2), course2);
        } catch (NullValueException e) {
        }

        try {
            courseRepo.update(null);
            assert (false);
        } catch (NullValueException e) {
        }
    }
}