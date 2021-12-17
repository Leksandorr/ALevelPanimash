package com.alevelhw.hw16.action;

import com.alevelhw.hw16.Student;

import java.util.Iterator;
import java.util.List;

public class StudentsActions {
    private final List<Student> students;

    public StudentsActions(List<Student> students) {
        this.students = students;
    }

    public void DoActionAfterSession() {
        Iterator <Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            int curs = student.getCourse();
            if (student.getMarks() < 3 || curs == 6) {
                if (curs == 6) {
                    System.out.println(student.getNane() + " успешно прошел(а) обучение.");
                } else {
                    System.out.println(student.getNane() + " отчислен(а).");
                }
                iterator.remove();
            }
            else {
                student.setCourse(curs + 1);
            }
        }
    }

    public void printStudents(List<Student> students, int course) {
        System.out.println("На " + course + " курсе учатся студенты:");
        int count = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getNane());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("На " + course + " нет студентов");
        }
    }
}
