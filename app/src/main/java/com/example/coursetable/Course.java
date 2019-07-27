package com.example.coursetable;

import org.litepal.crud.LitePalSupport;

public class Course extends LitePalSupport {

    private String course_name;

    private int day;

    private int course_start;

    private int course_end;

    private String classroom;

    private String teacher_name;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String classname) {
        this.course_name = classname;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getCourse_start() {
        return course_start;
    }

    public void setCourse_start(int course_start) {
        this.course_start = course_start;
    }

    public int getCourse_end() {
        return course_end;
    }

    public void setCourse_end(int course_end) {
        this.course_end = course_end;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

}


