package random.droidsonroids.pl.quiz;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import random.droidsonroids.pl.quiz.ui.finish.FinishActivity;
import random.droidsonroids.pl.quiz.ui.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void setup() {
        Intents.init();
    }

    @Test
    public void testStartLayout_success() {
        onView(withId(R.id.text_start)).check(matches(withText(R.string.quiz)));
        onView(withId(R.id.layout_edit_nothing)).check(matches(not(isDisplayed())));
        onView(withId(R.id.button_start)).perform(click());
        onView(withId(R.id.layout_edit_nothing)).check(matches(isDisplayed()));
    }

    @Test
    public void testJonSnow_success() {
        testStartLayout_success();
        onView(withId(R.id.edit_nothing)).perform(typeText("Jon Snow"));
        onView(withId(R.id.edit_nothing)).perform(closeSoftKeyboard());
        onView(withId(R.id.image_mobilization)).check(matches(isDisplayed()));
    }

    @Test
    public void testJonSnow_failure() {
        testStartLayout_success();
        onView(withId(R.id.edit_nothing)).perform(typeText("Ned Stark"));
        onView(withId(R.id.edit_nothing)).perform(closeSoftKeyboard());
        onView(withId(R.id.image_mobilization)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testMobilization_success() {
        testJonSnow_success();
        onView(withId(R.id.edit_event)).check(matches(isDisplayed()));
        onView(withId(R.id.image_one)).check(matches(not(isDisplayed())));
        onView(withId(R.id.edit_event)).perform(typeText("Mobilization"));
        onView(withId(R.id.edit_event)).perform(closeSoftKeyboard());
        onView(withId(R.id.image_one)).check(matches(isDisplayed()));
    }

    @Test
    public void testMobilization_failure() {
        testJonSnow_success();
        onView(withId(R.id.edit_event)).check(matches(isDisplayed()));
        onView(withId(R.id.image_one)).check(matches(not(isDisplayed())));
        onView(withId(R.id.edit_event)).perform(typeText("Droidcon"));
        onView(withId(R.id.edit_event)).perform(closeSoftKeyboard());
        onView(withId(R.id.image_one)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testChecking_success() {
        testMobilization_success();
        onView(withId(R.id.button_yes)).perform(click());
        onView((withId(R.id.layout_check))).check(matches(isDisplayed()));
    }

    @Test
    public void testChecking_failure() {
        testMobilization_success();
        onView(withId(R.id.button_no)).perform(click());
        onView((withId(R.id.layout_check))).check(matches(not(isDisplayed())));
    }


    @Test
    public void testMeganFox_success() {
        testChecking_success();
        onView(withId(R.id.checkbox_harry)).perform(click());
        onView((withId(R.id.layout_funny))).check(matches(not(isDisplayed())));
        onView(withId(R.id.checkbox_hulk)).perform(click());
        onView((withId(R.id.layout_funny))).check(matches(not(isDisplayed())));
        onView(withId(R.id.checkbox_plowing)).perform(click());
        onView((withId(R.id.layout_funny))).check(matches(not(isDisplayed())));
        onView(withId(R.id.checkbox_dove)).perform(click());
        onView((withId(R.id.layout_funny))).check(matches((isDisplayed())));
    }


    @Test
    public void testMeganFox_failure() {
        testChecking_success();
        onView(withId(R.id.checkbox_harry)).perform(click());
        onView(withId(R.id.checkbox_hulk)).perform(click());
        onView((withId(R.id.layout_funny))).check(matches(not(isDisplayed())));
    }

    @Test
    public void testEnd_success() {
        testMeganFox_success();
        onView(withId(R.id.layout_funny)).check(matches(isDisplayed()));
        onView(withId(R.id.button_funny)).perform(click());
        onView(withId(R.id.text_end)).check(matches(isDisplayed()));
    }

    @Test
    public void testEnd_failure() {
        testMeganFox_success();
        onView(withId(R.id.layout_funny)).check(matches(isDisplayed()));
        onView(withId(R.id.button_not_funny)).perform(click());
        onView(withId(R.id.text_end)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testIntent_success() {
        testEnd_success();

        onView(withId(R.id.button_shadow)).check(matches(isDisplayed()));
        onView(withId(R.id.button_shadow)).perform(click());
        intended(hasComponent(FinishActivity.class.getName()));
        onView(withId(R.id.button_share)).check(matches(isDisplayed()));
    }


    @Test
    public void testShareIntent_success() {
        testIntent_success();

        onView(withId(R.id.button_share)).check(matches(isDisplayed()));
        onView(withId(R.id.button_share)).perform(click());
        intended(hasAction(Intent.ACTION_CHOOSER));
    }

}