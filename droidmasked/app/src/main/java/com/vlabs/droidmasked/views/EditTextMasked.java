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
        Log.i("CYCLELYFE", "Constructor");
    }

    private void retrieveMasks()
    {
        String maskRaw = mTypedArray.getString(R.styleable.DroidMaskedView_mask);
        mMaskArray = maskRaw.split("\\|");
        //selectMaskDefault();
    }

    @Override
    protected void onTextChanged(CharSequence cs, int start, int lengthBefore, int lengthAfter) {
        Log.i("CYCLELYFE", "onTextChanged");
        String str = unmask(cs.toString());
        //String str = TelefoneMaskUtil.unmask(s.toString());
        //String mask = "";
        //String defaultMask = getDefaultMask(str);
        String mask = selectMaskDefault();
//        switch (str.length()) {
//            case 11:
//                mask = mask11;
//                break;
//            case 10:
//                mask = mask10;
//                break;
//            case 9:
//                mask = mask9;
//                break;
//            default:
//                mask = defaultMask;
//                break;
//        }

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

    private String selectMaskDefault() //TODO change name this method
    {
        String maskDefault = "";
        if(mMaskArray != null)
        {
            Arrays.sort(mMaskArray, new ComparatorUtil());

            for(int i = 0; i < mMaskArray.length; i++)
            {
                if((maskDefault = mMaskArray[i]).length() < maskDefault.length())
                {
                    maskDefault = mMaskArray[i];
                }
            }
        }
        return maskDefault;
    }

//    private void getSpecial(String mask)
//    {
//        String specialCharacters;
//        Pattern p = Pattern.compile("[^\\w\\*]");
//        Matcher m = p.matcher(mask);
//        while (m.find()) {
//            String code = m.group();
//            specialCharacters = code;
//        }
//    }
}
