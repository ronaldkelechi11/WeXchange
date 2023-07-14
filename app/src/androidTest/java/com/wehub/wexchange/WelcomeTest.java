package com.wehub.wexchange;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WelcomeTest {

    @Rule
    public ActivityScenarioRule<Welcome> mActivityScenarioRule =
            new ActivityScenarioRule<>(Welcome.class);

    @Test
    public void welcomeTest() {
    }
}
