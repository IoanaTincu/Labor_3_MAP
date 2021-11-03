package repository;

import exceptions.NullValueException;
import model.Course;
import model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    PersonRepository<Student> studentRepo = new PersonRepository<Student>();

    List<Course> enrolledCourses1 = new ArrayList<>();
    List<Course> enrolledCourses2 = new ArrayList<>();
    Student student1 = new Student(410, "Stefan", "Gorea", 17, enrolledCourses1);
    Student student2 = new Student(113, "Luca", "Tompea", 28, enrolledCourses1);

    @BeforeEach
    public void setUp() {
        try {
            studentRepo.save(student1);
        } catch (NullValueException e) {
        }
    }

    @Test
    void findOne() {
        try {
            assertEquals(studentRepo.findOne(student1.getId()), student1);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.findOne(student2.getId()), null);
        } catch (NullValueException e) {
        }

        try {
            studentRepo.findOne(null);
            assert (false);
        } catch (NullValueException e) {
        }

    }

    @Test
    void save() {
        try {
            assertEquals(studentRepo.save(student2), null);
        } catch (NullValueException e) {
        }

        assertEquals(studentRepo.size(), 2);
        try {
            assertEquals(studentRepo.findOne(student2.getId()), student2);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.save(student2), student2);
        } catch (NullValueException e) {
        }

        try {
            studentRepo.save(null);
            assert (false);
        } catch (NullValueException e) {
        }

    }

    @Test
    void delete() {
        try {
            studentRepo.delete(null);
            assert (false);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.delete(student2.getId()), null);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.delete(student1.getId()), student1);
        } catch (NullValueException e) {
        }

        assertEquals(studentRepo.size(), 0);

    }

    @Test
    void update() {
        Student newStudent1 = new Student(410, "Stefan", "Blaga", 17, enrolledCourses1);

        try {
            assertEquals(studentRepo.update(newStudent1), null);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.findOne(newStudent1.getId()), newStudent1);
        } catch (NullValueException e) {
        }

        try {
            assertEquals(studentRepo.update(student2), student2);
        } catch (NullValueException e) {
        }

        try {
            studentRepo.update(null);
            assert (false);
        } catch (NullValueException e) {
        }

    }
}