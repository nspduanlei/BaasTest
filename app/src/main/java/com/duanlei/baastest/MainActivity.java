package com.duanlei.baastest;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "167db8a182bf17559eebffaacc8e28c3");
    }

    public void addData(View v) {
        //保存数据
        Feedback feedbackObj = new Feedback();
        feedbackObj.setName("name1");
        feedbackObj.setFeedback("feedback1");
        feedbackObj.save(MainActivity.this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "submit success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(MainActivity.this, "submit failure", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void queryData(View v) {
        //查询数据
        BmobQuery<Feedback> query = new BmobQuery<>();
        query.findObjects(MainActivity.this, new FindListener<Feedback>() {
            @Override
            public void onSuccess(List<Feedback> list) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this
                );

                builder.setTitle("Query");
                String str = "";
                for (Feedback feedback : list) {
                    str += feedback.getName() + ":" +
                            feedback.getFeedback() + "\n";
                }

                builder.setMessage(str);
                builder.create().show();
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }
}
