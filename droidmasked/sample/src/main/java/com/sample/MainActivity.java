package com.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.vlabs.droidmasked.views.EditTextMasked;


/**
 * Created by vilmar on 18/08/15.
 */
public class MainActivity extends AppCompatActivity {

    private EditTextMasked mEditTextMasked;
    private String[] masks = {"###-###", "###.###-##", "##-##"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextMasked = (EditTextMasked) findViewById(R.id.et_mask);
        //mEditText.addMask("###.###.###-##");
        mEditTextMasked.addMask(masks);
    }

}
