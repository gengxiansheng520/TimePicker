package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.timepicker.config.PickerConfig;
import com.example.timepicker.data.Type;
import com.example.timepicker.data.WheelCalendar;
import com.example.timepicker.listener.OnDateSetListener;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements OnDateSetListener {

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    PickerConfig mPickerConfig;
    private TimeWheel mTimeWheel;
    private long mCurrentMillSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog();
    }

    private void showDialog() {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        mPickerConfig = new PickerConfig();
        mPickerConfig.mCallBack = this;
        mPickerConfig.mDay = "DAY";
        mPickerConfig.mHour = "Hour";
        mPickerConfig.mMinute = "Minute";
        mPickerConfig.cyclic = false;
        mPickerConfig.mMinCalendar = new WheelCalendar(System.currentTimeMillis());
        mPickerConfig.mMaxCalendar = new WheelCalendar(System.currentTimeMillis() + tenYears);
        mPickerConfig.mCurrentCalendar = new WheelCalendar(System.currentTimeMillis());
        mPickerConfig.mType = Type.MONTH_DAY_HOUR_MIN;
        View view = findViewById(R.id.included).getRootView();
        mTimeWheel = new TimeWheel(view, mPickerConfig);
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

    }
}