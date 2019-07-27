package com.example.coursetable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int height;
    private LinearLayout ll;

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
        //动态测量
        final RelativeLayout ll = (RelativeLayout) findViewById(R.id.monday);
        ll.post(new Runnable(){
            public void run(){
                height = ll.getHeight();
                Log.d("timer", String.valueOf(height));
                //调用数据库渲染课程
                loadData();
            }
        });


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
        textView_1.setText(format(calendar.get(Calendar.DAY_OF_MONTH)));
        textView_2.setText(format(calendar.get(Calendar.MONTH)+1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //LinearLayout content = () findViewById(R.id.monday);
        //content.measure(0,0);
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
                Toast.makeText(MainActivity.this, "预留Button，暂时还没写！！！", Toast.LENGTH_SHORT).show();
                break;

            case R.id.youg :
                Intent intent1 = new Intent(this, about_me.class);
                startActivity(intent1);
                break;

            case R.id.zuog :
                Toast.makeText(MainActivity.this, "计划Button，施工中！！！", Toast.LENGTH_SHORT).show();
                break;

            case R.id.daoru :
                Toast.makeText(MainActivity.this, "计划Button，施工中！！！", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void loadData() {
        List<Course> courses = LitePal.findAll(Course.class);
        for (Course course : courses) {
            //动态设定并加载view
            craeteCourseView(course);
        }
    }
    //Course course
    private void craeteCourseView(final Course course) {
        int getDay = course.getDay();
        if (getDay < 1 || getDay > 7 || course.getCourse_start() > course.getCourse_end()) {
            Toast.makeText(MainActivity.this, "emm...请不要输入错误的数据", Toast.LENGTH_SHORT).show();
        } else {
            int dayId = 0;
            switch (getDay) {
                case 1:
                    dayId = R.id.monday;
                    break;
                case 2:
                    dayId = R.id.tuesday;
                    break;
                case 3:
                    dayId = R.id.wednesday;
                    break;
                case 4:
                    dayId = R.id.thursday;
                    break;
                case 5:
                    dayId = R.id.friday;
                    break;
                case 6:
                    dayId = R.id.saturday;
                    break;
                case 7:
                    dayId = R.id.weekday;
                    break;
                default:
                    break;
            }
            final RelativeLayout day = findViewById(dayId);

            //设定Viewcard
            View v = LayoutInflater.from(this).inflate(R.layout.course_card, null); //加载course_card
            RelativeLayout content = (RelativeLayout) findViewById(R.id.monday);
            v.setY(height / 10 * (course.getCourse_start() - 1));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (course.getCourse_end() - course.getCourse_start() + 1) * height / 10);
            v.setLayoutParams(params);
            TextView text = v.findViewById(R.id.card_text_view);
            text.setText(course.getCourse_name() + "\n" + course.getClassroom() + "\n" + course.getTeacher_name());//显示课程信息
            day.addView(v);
            //删除课程
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Log.d("ss", String.valueOf(course.getCourse_start()));
                    Intent intent = new Intent(MainActivity.this, DeleteCourse.class);
                    Bundle bd = new Bundle();
                    bd.putInt("start", course.getCourse_start());
                    bd.putInt("end", course.getCourse_end());
                    bd.putInt("day", course.getDay());
                    intent.putExtras(bd);
                    startActivity(intent);
                    return true;
                }
            });
        }
    }

}
