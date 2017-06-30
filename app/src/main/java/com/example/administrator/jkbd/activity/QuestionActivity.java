package com.example.administrator.jkbd.activity;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.jkbd.QuestionApplication;
import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.ExamInfo;

/**
 * Created by Administrator on 2017/6/29.
 */

public class QuestionActivity extends AppCompatActivity{
    TextView tvExamInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initView();
        initData();
    }

    private void initView() {
        tvExamInfo= (TextView) findViewById(R.id.tv_examinfo);
    }

    private void initData() {
        ExamInfo examInfo = QuestionApplication.getInstance().getmExamInfo();
        if(examInfo!=null){
            showData(examInfo);
        }

    }

    private void showData(ExamInfo examInfo) {
        tvExamInfo.setText(examInfo.toString());
    }
}
