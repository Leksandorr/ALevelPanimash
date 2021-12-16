package com.alevelhw.hw16;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private final String nane;
    private final String group;
    int course;
    int marks;

    public Student(String nane, String group, int course, int marks) {
        this.nane = nane;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "{" + nane +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", marks=" + marks +
                '}';
    }
}
