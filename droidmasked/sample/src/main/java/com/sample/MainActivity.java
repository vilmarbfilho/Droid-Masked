package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


/**
 * Created by vilmar on 18/08/15.
 */
public class MainActivity extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mEditText = (EditText) findViewById(R.id.et_mask);
        //mEditText.addTextChangedListener(TelefoneMaskUtil.insert(mEditText));
    }

}
