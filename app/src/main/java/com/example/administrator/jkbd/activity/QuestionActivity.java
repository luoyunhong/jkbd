package com.example.administrator.jkbd.activity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jkbd.QuestionApplication;
import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.ExamInfo;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.biz.ExamBiz;
import com.example.administrator.jkbd.biz.IExamBiz;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class QuestionActivity extends AppCompatActivity {
    TextView tvExamInfo, tvExamtitle, tvop1, tvop2, tvop3, tvop4;
    ImageView mImageView;
    IExamBiz biz;

    boolean isLoadExamInfo = false;
    boolean isLoadQuestions = false;

    LoadExamBroadcast mLoadExamBroadcast;
    LoadQuestionBroadcast mLoadQuestionBroadcast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        mLoadExamBroadcast=new LoadExamBroadcast();
        mLoadQuestionBroadcast=new LoadQuestionBroadcast();
        setListener();
        initView();
        loadData();
    }

    private void setListener() {
        registerReceiver(mLoadExamBroadcast,new IntentFilter(QuestionApplication.LOAD_EXAN_INFO));
        registerReceiver(mLoadQuestionBroadcast,new IntentFilter(QuestionApplication.LOAD_EXAN_QUESTION));
    }

    private void loadData() {
        biz = new ExamBiz();
        new Thread(new Runnable() {
            @Override
            public void run() {
                biz.beginExam();
            }
        }).start();
    }

    private void initView() {
        tvExamInfo = (TextView) findViewById(R.id.tv_examinfo);
        tvExamtitle = (TextView) findViewById(R.id.tv_exam_title);
        tvop1 = (TextView) findViewById(R.id.tv_op1);
        tvop2 = (TextView) findViewById(R.id.tv_op2);
        tvop3 = (TextView) findViewById(R.id.tv_op3);
        tvop4 = (TextView) findViewById(R.id.tv_op4);
        mImageView = (ImageView) findViewById(R.id.im_exam_image);
    }

    private void initData() {
        if (isLoadExamInfo && isLoadQuestions) {
            ExamInfo examInfo = QuestionApplication.getInstance().getmExamInfo();
            if (examInfo != null) {
                showData(examInfo);
            }
            List<Question> questionList = QuestionApplication.getInstance().getmQuestionList();
            if (questionList != null) {
                showQuestion(questionList);
            }
        }
    }

    private void showQuestion(List<Question> questionList) {
        Question question = questionList.get(0);
        if (questionList != null) {
            tvExamtitle.setText(question.getQuestion());
            tvop1.setText(question.getItem1());
            tvop2.setText(question.getItem2());
            tvop3.setText(question.getItem3());
            tvop4.setText(question.getItem4());
            Picasso.with(QuestionActivity.this)
                    .load(question.getUrl())
                    .into(mImageView);
        }
    }

    private void showData(ExamInfo examInfo) {
        tvExamInfo.setText(examInfo.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mLoadExamBroadcast!=null){
            unregisterReceiver(mLoadExamBroadcast);
        }
        if(mLoadQuestionBroadcast!=null){
            unregisterReceiver(mLoadQuestionBroadcast);
        }
    }

    class LoadExamBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isSuccess = intent.getBooleanExtra(QuestionApplication.LOAD_DATA_SUCCESS, false);
            Log.e("LoadExamBroadcast","LoadExamBroadcast,isSuccess="+isSuccess);
            if (isSuccess) {
                isLoadExamInfo = true;
            }
            initData();
        }
    }

        class LoadQuestionBroadcast extends BroadcastReceiver {

            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isSuccess = intent.getBooleanExtra(QuestionApplication.LOAD_DATA_SUCCESS, false);
                Log.e("LoadQuestionBroadcast","LoadQuestionBroadcast,isSuccess="+isSuccess);
                if (isSuccess) {
                    isLoadQuestions = true;
                }
                initData();
            }
        }
 }

