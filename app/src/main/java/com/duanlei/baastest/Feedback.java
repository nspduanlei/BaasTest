package com.duanlei.baastest;

import cn.bmob.v3.BmobObject;

/**
 * Author: duanlei
 * Date: 2016-01-18
 */
public class Feedback extends BmobObject {

    private String name;
    private String feedback;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
