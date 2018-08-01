package app.com.practiceapplication;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<NewsActivity> mActivityRule =
            new ActivityTestRule<>(NewsActivity.class);

    @Test
    public void listGoesOverTheFold() {
        if(getRVcount() > 0){
            onView(withId(R.id.newsRecylerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        }else{
            assertFalse("Recycler view has not item", true);
        }
    }

    private int getRVcount(){
        RecyclerView recyclerView =  mActivityRule.getActivity().findViewById(R.id.newsRecylerView);
        return recyclerView.getAdapter().getItemCount();
    }
}