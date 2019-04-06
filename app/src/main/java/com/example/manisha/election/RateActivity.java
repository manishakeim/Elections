package com.example.manisha.election;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.EditText;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        EditText t = (EditText) findViewById(R.id.editText_review);
        t.setGravity(Gravity.CENTER);
    }
}
