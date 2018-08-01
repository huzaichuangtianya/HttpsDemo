package com.quliang.httpsdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView textView =findViewById(R.id.textView);
//        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });
    }


    private void post(){
        OkGo.<String>post("https://10.50.30.244:443/SxgwPhoneServer/user/getCode.do")//
                .tag(this)//
//                .headers("header1", "headerValue1")//
                .params("uid", "paramValue1")//
                .isMultipart(false)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        //注意这里已经是在主线程了
                        String data = response.body();//这个就是返回来的结果
                        AppLog.D("response.body():"+response.body());

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        AppLog.D("onError.code:"+response.code());
                        AppLog.D("onError.message:"+response.message());
                    }
                });
    }


}
