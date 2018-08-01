package app.com.practiceapplication.viewmodel;

import android.databinding.ObservableField;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.util.Log;
import app.com.practiceapplication.adapters.NewsAdapter;
import app.com.practiceapplication.model.Result;
import app.com.practiceapplication.model.data.RetrofitHelper;
import rx.Subscriber;

public class MainViewModel {
  public ObservableField<String> exception;
  private Subscriber<Result> subscriber;
  private NewsAdapter newsAdapter;
  CountingIdlingResource countingIdlingResource;

  public MainViewModel(NewsAdapter newsAdapter,CountingIdlingResource countingIdlingResource) {
    this.newsAdapter = newsAdapter;
    this.countingIdlingResource = countingIdlingResource;

    initData();
    getNews();
  }

  private void getNews() {
    subscriber = new Subscriber<Result>() {
      @Override
      public void onCompleted() {
        Log.d("@Test_logs", "onCompleted");
        countingIdlingResource.decrement();

      }

      @Override
      public void onError(Throwable e) {
        countingIdlingResource.decrement();
        exception.set(e.getMessage());
      }

      @Override
      public void onNext(Result resultModel) {
        Log.d("@Test_logs", "onNext()");
        newsAdapter.addItem(resultModel);
      }

    };
    Log.d("@Test_logs", "getNews()");
    countingIdlingResource.increment();
    RetrofitHelper.getInstance().getNews(subscriber);
  }

  private void initData() {
    exception = new ObservableField<>();
  }
}
