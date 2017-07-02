package com.example.administrator.jkbd.dao;

import android.util.Log;

import com.example.administrator.jkbd.QuestionApplication;
import com.example.administrator.jkbd.bean.ExamInfo;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.bean.Result;
import com.example.administrator.jkbd.utils.OkHttpUtils;
import com.example.administrator.jkbd.utils.ResultUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */

public class ExamDao implements IExamDao {
    @Override
    public void loadExamInfo() {
        OkHttpUtils<ExamInfo> utils=new OkHttpUtils<>(QuestionApplication.getInstance());
        String url="http://101.251.196.90:8080/JztkServer/examInfo";
        utils.url(url)
                .targetClass(ExamInfo.class)
                .execute(new OkHttpUtils.OnCompleteListener<ExamInfo>() {
                    @Override
                    public void onSuccess(ExamInfo result) {
                        Log.e("main","result="+result);
                        QuestionApplication.getInstance().setmExamInfo(result);
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);
                    }
                });
    }

    @Override
    public void loadQuestionLists() {
        OkHttpUtils<String> utils1=new OkHttpUtils<>(QuestionApplication.getInstance());
        String url2="http://101.251.196.90:8080/JztkServer/getQuestions?testType=rand";
        utils1.url(url2)
                .targetClass(String.class)
                .execute(new OkHttpUtils.OnCompleteListener<String>() {
                    @Override
                    public void onSuccess(String jsonStr) {
                        Result result = ResultUtils.getListResultFromJson(jsonStr);
                        if(result!=null && result.getError_code()==0){
                            List<Question> list = result.getResult();
                            if(list!=null && list.size()>0){
                                QuestionApplication.getInstance().setmQuestionList(list);
                            }
                        }

                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);
                    }
                });
    }
}
