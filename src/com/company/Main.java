package com.company;

import model.Course;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Course> listCourses1 = new ArrayList<>();
        List<Student> listStudents1 = new ArrayList<>();
        Student student1 = new Student(10282021,"Andrei","Moldovan",7,listCourses1);
        Teacher teacher1 = new Teacher(40,"Mugur","Acu",listCourses1);
        Course course1 = new Course(42,"Analiza matematica",teacher1,42,listStudents1,5);

        System.out.println(course1);
        System.out.println(teacher1);
        System.out.println(student1);
    }
}
