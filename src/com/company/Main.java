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
        Student student1 = new Student("Andrei","Moldovan",10282021, 7,listCourses1);
        Teacher teacher1 = new Teacher("Mugur","Acu",listCourses1);
        Course course1 = new Course("Analiza matematica",teacher1,42,listStudents1,5);

        System.out.println(course1);
        System.out.println(teacher1);
        System.out.println(student1);
    }
}
