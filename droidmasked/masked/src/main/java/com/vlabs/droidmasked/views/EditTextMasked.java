package com.vlabs.droidmasked.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.vlabs.droidmasked.R;
import com.vlabs.droidmasked.comparator.ComparatorUtil;

import java.util.Arrays;


/**
 * Created by vilmar on 5/16/15.
 */
public class EditTextMasked extends EditText {

    private TypedArray mTypedArray;
    private String[] mMaskArray;

    boolean isUpdating = false;
    String old = "";

    public EditTextMasked(Context context) {
        super(context);
    }

    public EditTextMasked(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.DroidMaskedView, 0, 0);
        retrieveMasks();
    }

    private void retrieveMasks()
    {
        String maskRaw = mTypedArray.getString(R.styleable.DroidMaskedView_mask);
        mMaskArray = maskRaw.split("\\|");
    }

    @Override
    protected void onTextChanged(CharSequence cs, int start, int lengthBefore, int lengthAfter) {
        String str = unmask(cs.toString());
        String mask = selectMask(str);

        String mascara = "";
        if (isUpdating) {
            old = str;
            isUpdating = false;
            return;
        }
        int i = 0;
        for (char m : mask.toCharArray()) {
            if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                mascara += m;
                continue;
            }

            try {
                mascara += str.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        isUpdating = true;
        setText(mascara);
        setSelection(mascara.length());

    }

    public String unmask(String s) {
        return s.replaceAll("[^a-zA-Z0-9]+","");
    }

    private String removeMask(String s){
        return s.replaceAll("[^#*]+","");
    }

    private String selectMask(String str)
    {
        String maskDefault = "";
        if(mMaskArray != null)
        {
            Arrays.sort(mMaskArray, new ComparatorUtil());
            maskDefault = mMaskArray[0];
            int j = 1;

            for(int i = 0; i < mMaskArray.length; i++)
            {
                int size = (removeMask(mMaskArray[i]).length());
                if(str.length() > size && j < mMaskArray.length)
                {
                    maskDefault = mMaskArray[j];
                }
                j++;
            }
        }
        return maskDefault;
    }

}
