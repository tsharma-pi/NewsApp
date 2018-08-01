package app.com.practiceapplication;

import android.util.Log;
import junit.framework.Assert;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class NewsDetailActivityTest {

  NewsDetailActivity newsDetailActivity;

  @Test public void onCreate() {
    onView(withId(R.id.webView)).check(matches(isDisplayed()));
  }

  @Test public void getUrl() {
    newsDetailActivity = NewsDetailActivity.getInstance();
    Assert.assertEquals(newsDetailActivity.getUrl(), null);
    Log.e("@Test_logs", "url is null");
  }
}