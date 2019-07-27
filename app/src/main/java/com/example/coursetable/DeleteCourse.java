package com.example.coursetable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;

public class DeleteCourse extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_course);
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);


    }


    //@Override
    public void onClick(View view) {
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        String start = String.valueOf(bd.getInt("start"));
        String end = String.valueOf(bd.getInt("end"));
        String day = String.valueOf(bd.getInt("day"));
        switch (view.getId()) {
            case R.id.yes :
                LitePal.deleteAll(Course.class, "course_start = ? and course_end = ? and day = ?", start, end, day);
                finish();
                break;
            case R.id.no :
                finish();
                break;
            default:
                break;
        }
    }
}
