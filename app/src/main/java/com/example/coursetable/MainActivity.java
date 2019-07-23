package com.example.coursetable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView_1 = (TextView) findViewById(R.id.month);
        TextView textView_2 = (TextView) findViewById(R.id.riqi);
        Button zuog = (Button) findViewById(R.id.zuog);
        Button tianjia = (Button) findViewById(R.id.tianjia);
        Button daoru = (Button) findViewById(R.id.daoru);
        Button fenxiang = (Button) findViewById(R.id.fenxiang);
        Button youg = (Button) findViewById(R.id.youg);
        zuog.setOnClickListener(this);
        tianjia.setOnClickListener(this);
        daoru.setOnClickListener(this);
        fenxiang.setOnClickListener(this);
        youg.setOnClickListener(this);

        //从数据库中加载数据
        //loadData();

        //工具条隐藏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Calendar calendar = Calendar.getInstance();
        /*int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.get(Calendar.HOUR_OF_DAY))
        calendar.get(Calendar.MINUTE))
        calendar.get(Calendar.SECOND))*/
        textView_1.setText(format(calendar.get(Calendar.MONTH)+1));
        textView_2.setText(format(calendar.get(Calendar.MONTH)+1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
    }

    /* 格式化字符串(7:3->07:03) */
    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1)
            s = "0" + s;
        return s;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tianjia :
                Intent intent = new Intent(this, AddCourse.class);
                startActivity(intent);
                break;

            case R.id.fenxiang :
                Toast.makeText(MainActivity.this, "傻子，这还没写呢！！！", Toast.LENGTH_SHORT).show();
        }
    }
}
