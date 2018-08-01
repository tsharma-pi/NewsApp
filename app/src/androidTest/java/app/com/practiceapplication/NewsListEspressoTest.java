package app.com.practiceapplication;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class) @LargeTest public class NewsListEspressoTest {
  private IdlingResource mIdlingResource;
  NewsDetailActivity newsDetailActivity;

  @Rule public ActivityTestRule<NewsActivity> mActivityTestRule =
      new ActivityTestRule<NewsActivity>(NewsActivity.class){
        @Override protected void beforeActivityLaunched() {
          //super.beforeActivityLaunched();
          Log.d("@Test_logs", "ActivityTestRule");
          mIdlingResource = NewsActivity.getIdlingResourceForAuthActivity();
          Espresso.registerIdlingResources(mIdlingResource);
        }
      };
  //private NewsActivity mActivity;

  @Before public void Setup() {
    //get idling resource for authentication
    //mIdlingResource = mActivityTestRule.getActivity().getIdlingResourceForAuthActivity();
    Log.d("@Test_logs", "Setup");
    //get current activity
    //mActivity = mActivityTestRule.getActivity();

  }

  @Test public void checkList() {
    Log.d("@Test_logs", "checkList");
    //Espresso.registerIdlingResources(mIdlingResource);

    if (getRVcount() > 0) {
      onView(withId(R.id.newsRecylerView)).perform(
          RecyclerViewActions.actionOnItemAtPosition(0, click()));
    } else {
      assertFalse("Recycler view has not item", true);
    }
  }

  private int getRVcount() {
    Log.d("@Test_logs", "getRVcount");
    RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.newsRecylerView);
    return recyclerView.getAdapter().getItemCount();
  }

  @After public void unregisterIdlingResource() {
    if (mIdlingResource != null) {
      Espresso.unregisterIdlingResources(mIdlingResource);
    }
  }
/*
  @Test public void getUrl() {
    newsDetailActivity = NewsDetailActivity.getInstance();
    Assert.assertEquals(newsDetailActivity.getUrl(), null);
    Log.e("@Test_logs", "url is null");
  }*/
}