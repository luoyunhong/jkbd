package com.example.administrator.jkbd;

import android.app.Application;
import android.util.Log;

import com.example.administrator.jkbd.bean.ExamInfo;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.bean.Result;
import com.example.administrator.jkbd.biz.ExamBiz;
import com.example.administrator.jkbd.biz.IExamBiz;
import com.example.administrator.jkbd.utils.OkHttpUtils;
import com.example.administrator.jkbd.utils.ResultUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */

public class QuestionApplication extends Application{
    public static String LOAD_EXAN_INFO="load_exam_info";
    public static String LOAD_EXAN_QUESTION="load_exam_question";
    public static String LOAD_DATA_SUCCESS="load_data_success";
    ExamInfo mExamInfo;
    List<Question> mQuestionList;
    private static QuestionApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
    public static QuestionApplication getInstance(){
        return instance;
    }



    public ExamInfo getmExamInfo() {
        return mExamInfo;
    }

    public void setmExamInfo(ExamInfo mExamInfo) {
        this.mExamInfo = mExamInfo;
    }

    public List<Question> getmQuestionList() {
        return mQuestionList;
    }

    public void setmQuestionList(List<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
    }
}
