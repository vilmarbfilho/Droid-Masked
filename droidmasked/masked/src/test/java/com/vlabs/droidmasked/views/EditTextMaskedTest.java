package com.vlabs.droidmasked.views;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by vilmar on 5/22/15.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", sdk = 22)
public class EditTextMaskedTest {

    private EditTextMasked editTextMasked;

    @Before
    public void setUp()
    {
        editTextMasked = new EditTextMasked(RuntimeEnvironment.application);
    }


    @Test
    public void testUnmask() throws Exception {
        String textWithoutMask = editTextMasked.unmask("T.E/.S*T");
        assertTrue(textWithoutMask.equals("TEST"));

    }
}