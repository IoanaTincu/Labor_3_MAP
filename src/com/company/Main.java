package com.company;

import exceptions.NullValueException;
import model.Course;
import model.Student;
import model.Teacher;
import repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Course> listCourses1 = new ArrayList<>();
        List<Student> listStudents1 = new ArrayList<>();
        Student student1 = new Student(10282021,"Andrei","Moldovan",7,listCourses1);
        Teacher teacher1 = new Teacher(40,"Mugur","Acu",listCourses1);
        Teacher teacher2 = new Teacher(20,"Simian","Dana",listCourses1);
        Course course1 = new Course(10302021,"Analiza matematica",teacher1,42,listStudents1,5);
        Course course2 = new Course(10302021,"Algoritmi fundamentali",teacher2,30,listStudents1,5);

        System.out.println(course1);
        System.out.println(teacher1);
        System.out.println(student1);

        CourseRepository courseRepo = new CourseRepository();
        try {
            courseRepo.save(course1);
        }
        catch(NullValueException e) {
            System.out.println(e);
        }

        System.out.println(courseRepo.size());
        for(Course course : courseRepo.findAll())
            System.out.println(course);

        try {
            System.out.println(courseRepo.findOne(new Long(10302021)));
            System.out.println(courseRepo.findOne(null));
        }
        catch(NullValueException e) {
            System.out.println(e);
        }

        System.out.println("Aici");
        try {
            System.out.println(courseRepo.update(course2));
        }
        catch(NullValueException e) {
            System.out.println(e);
        }

        for(Course course : courseRepo.findAll())
            System.out.println(course);

        try {
            System.out.println(courseRepo.delete(new Long(36302021)));
        }
        catch(NullValueException e) {
            System.out.println(e);
        }

        System.out.println("RepoList: ");
        for(Course course : courseRepo.findAll())
            System.out.println("RepoList: " + course);
    }
}
