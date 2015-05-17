package com.vlabs.droidmasked.comparator;

import java.util.Comparator;

/**
 * Created by vilmar on 5/17/15.
 */
public class ComparatorUtil implements Comparator<String> {

    public int compare(String o1, String o2)
    {
        if (o1.length() > o2.length())
        {
            return 1;
        }
        else if (o1.length() < o2.length())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
