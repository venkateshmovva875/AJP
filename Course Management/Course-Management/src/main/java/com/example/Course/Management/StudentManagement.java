package com.example.Course.Management;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudentManagement {
    private int id;
    private String name;
    private List<Integer> courseIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCourseIDs() {
        return courseIds;
    }

    public void setCourseIDs(List<Integer> courseIds2) {
        this.courseIds = courseIds2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CourseIDs='" + courseIds + '\'' +
                '}';
    }
}
