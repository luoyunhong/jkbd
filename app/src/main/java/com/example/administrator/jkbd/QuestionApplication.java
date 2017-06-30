package com.example.administrator.jkbd;

import android.app.Application;
import android.util.Log;

import com.example.administrator.jkbd.bean.ExamInfo;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */

public class QuestionApplication extends Application{
    ExamInfo mExamInfo;
    List<Question> mQuestionList;
    private static QuestionApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        initDate();
    }
    public static QuestionApplication getInstance(){
        return instance;
    }

    private void initDate() {
        OkHttpUtils<ExamInfo> utils=new OkHttpUtils<>(instance);
        String url="http://101.251.196.90:8080/JztkServer/examInfo";
        utils.url(url)
                .targetClass(ExamInfo.class)
                .execute(new OkHttpUtils.OnCompleteListener<ExamInfo>() {
                    @Override
                    public void onSuccess(ExamInfo result) {
                        Log.e("main","result="+result);
                        mExamInfo=result;
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);
                    }
                });
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
