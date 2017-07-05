package com.example.administrator.jkbd.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jkbd.QuestionApplication;
import com.example.administrator.jkbd.R;
import com.example.administrator.jkbd.bean.Question;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */

public class QuestionAdapter extends BaseAdapter {
    Context mContext;
    List<Question> questionList;
    public QuestionAdapter(Context mContext) {
        this.mContext = mContext;
        questionList = QuestionApplication.getInstance().getmQuestionList();
    }

    @Override
    public int getCount() {
        return questionList==null?0:questionList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_question, null);
        TextView tvNo= (TextView) view.findViewById(R.id.tv_no);
        ImageView ivQuestion= (ImageView) view.findViewById(R.id.iv_question);
        String ua=questionList.get(position).getUserAnswer();
        String ra=questionList.get(position).getAnswer();
        if(ua!=null && !ua.equals("")){
            ivQuestion.setImageResource(ua.equals(ra)?R.mipmap.answer24x24:R.mipmap.error);
        }else {
            ivQuestion.setImageResource(R.mipmap.unknow);
        }
        tvNo.setText("第"+(position+1)+"题");
        return view;
    }
}
