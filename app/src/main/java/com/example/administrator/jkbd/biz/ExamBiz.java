package com.example.administrator.jkbd.biz;

import com.example.administrator.jkbd.QuestionApplication;
import com.example.administrator.jkbd.bean.Question;
import com.example.administrator.jkbd.dao.ExamDao;
import com.example.administrator.jkbd.dao.IExamDao;

import java.util.List;

/**
 * Created by Administrator on 2017/7/2.
 */

public class ExamBiz implements IExamBiz {
    IExamDao dao;
    int examIndex=0;
    List<Question> questionList =null;

    public ExamBiz() {
        this.dao = new ExamDao();
    }

    @Override
    public void beginExam() {
        examIndex=0;
        dao.loadExamInfo();
        dao.loadQuestionLists();

    }

    @Override
    public Question getExam() {
        questionList = QuestionApplication.getInstance().getmQuestionList();
        if(questionList!=null){
            return questionList.get(examIndex);
        }else {
            return null;
        }
    }

    @Override
    public Question nextQuestion() {
        if(questionList!=null && examIndex<questionList.size()-1){
            examIndex++;
            return questionList.get(examIndex);
        }else {
            return null;
        }
    }

    @Override
    public Question preQuestion() {
        if(questionList!=null && examIndex>0){
            examIndex--;
            return questionList.get(examIndex);
        }else {
            return null;
        }
    }

    @Override
    public void commitExam() {

    }

    @Override
    public String getExamIndex() {
        return (examIndex+1)+".";
    }
}
