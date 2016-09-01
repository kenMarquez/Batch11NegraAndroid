package com.def.batch11negraandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("OnDestroy");
    }

    public void log(String content) {
        Log.i("myLog", content);
    }


}
