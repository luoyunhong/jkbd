package com.example.administrator.jkbd.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class Result {

    /**
     * error_code : 0
     * reason : ok
     * result : [{"id":6,
     * "question":"这个标志是何含义？",
     * "answer":"4",
     * "item1":"右转车道",
     * "item2":"掉头车道",
     * "item3":"左转车道",
     * "item4":"直行车道",
     * "explains":"表示只准一切车辆直行。此标志设在直行的路口以前适当位置。",
     * "url":"http://images.juheapi.com/jztk/c1c2subject1/6.jpg"}]
     */

    private int error_code;
    private String reason;
    private List<Question> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Question> getResult() {
        return result;
    }

    public void setResult(List<Question> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 6
         * question : 这个标志是何含义？
         * answer : 4
         * item1 : 右转车道
         * item2 : 掉头车道
         * item3 : 左转车道
         * item4 : 直行车道
         * explains : 表示只准一切车辆直行。此标志设在直行的路口以前适当位置。
         * url : http://images.juheapi.com/jztk/c1c2subject1/6.jpg
         */
        private int id;
        private String question;
        private String answer;
        private String item1;
        private String item2;
        private String item3;
        private String item4;
        private String explains;
        private String url;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getItem1() {
            return item1;
        }

        public void setItem1(String item1) {
            this.item1 = item1;
        }

        public String getItem2() {
            return item2;
        }

        public void setItem2(String item2) {
            this.item2 = item2;
        }

        public String getItem3() {
            return item3;
        }

        public void setItem3(String item3) {
            this.item3 = item3;
        }

        public String getItem4() {
            return item4;
        }

        public void setItem4(String item4) {
            this.item4 = item4;
        }

        public String getExplains() {
            return explains;
        }

        public void setExplains(String explains) {
            this.explains = explains;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
