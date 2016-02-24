package com.rubyko.client;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {


    String str = new String();
    public ApplicationTest() {
        super(Application.class);

        assertEquals(str.equals(str), true);
    }



}