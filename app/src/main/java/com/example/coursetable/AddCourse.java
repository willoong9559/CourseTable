package com.example.coursetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class AddCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        final EditText input_courseName = (EditText) findViewById(R.id.course_name);
        final EditText input_day = (EditText) findViewById(R.id.day);
        final EditText input_courseStart = (EditText) findViewById(R.id.course_start);
        final EditText input_courseEnd = (EditText) findViewById(R.id.course_end);
        final EditText input_classroom = (EditText) findViewById(R.id.classroom);
        final EditText input_teacherName = (EditText) findViewById(R.id.teacher_name);

        Button button = (Button) findViewById(R.id.add_course);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String courseName = input_courseName.getText().toString();
                final String day = input_day.getText().toString();
                final String courseStart = input_courseStart.getText().toString();
                final String courseEnd = input_courseEnd.getText().toString();
                final String classroom = input_classroom.getText().toString();
                final String teacherName = input_teacherName.getText().toString();
                Toast.makeText(AddCourse.this, "ok", Toast.LENGTH_LONG).show();
                Course course = new Course();
                course.setCourse_name(courseName);
                course.setDay(Integer.valueOf(day));
                course.setCourse_start(Integer.valueOf(courseStart));
                course.setCourse_end(Integer.valueOf(courseEnd));
                course.setClassroom(classroom);
                course.setTeacher_name(teacherName);
                course.save();
                Intent intent = new Intent(AddCourse.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}
