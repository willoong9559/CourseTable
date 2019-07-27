package com.example.coursetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        switch (view.getId()) {
            case R.id.yes :
                //删除逻辑
                break;
            case R.id.no :
                finish();
                break;
            default:
                break;
        }
    }
}
