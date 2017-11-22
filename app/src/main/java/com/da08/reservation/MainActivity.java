package com.da08.reservation;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnEnd;
    private RadioButton radioDate;
    private RadioButton radioTime;
    private CalendarView calendarView;
    private TextView txtYear;
    private TextView txtMonth;
    private TextView txtDay;
    private TextView txtHours;
    private TextView txtMinute;
    private Chronometer chronometer;
    private TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        calendarView.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.BLUE);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.RED);
                Calendar curDate = Calendar.getInstance();
                curDate.setTimeInMillis(calendarView.getDate());
                txtYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
                txtMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
                txtDay.setText(Integer.toString(curDate.get(Calendar.DATE)));
                txtHours.setText(Integer.toString(time.getCurrentHour()));
                txtMinute.setText(Integer.toString(time.getCurrentMinute()));

            }
        });
    }

    private void initView() {
        btnStart = (Button) findViewById(R.id.btnStart);
        radioDate = (RadioButton) findViewById(R.id.radioDate);
        radioTime = (RadioButton) findViewById(R.id.radioTime);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        txtYear = (TextView) findViewById(R.id.txtYear);
        txtMonth = (TextView) findViewById(R.id.txtMonth);
        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHours = (TextView) findViewById(R.id.txtHours);
        txtMinute = (TextView) findViewById(R.id.txtMinute);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        time = (TimePicker) findViewById(R.id.time);
    }
}
