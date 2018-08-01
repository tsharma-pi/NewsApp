package app.com.practiceapplication.viewmodel;

import android.databinding.ObservableField;
import android.util.Log;
import app.com.practiceapplication.adapters.NewsAdapter;
import app.com.practiceapplication.model.Result;
import app.com.practiceapplication.model.data.RetrofitHelper;
import rx.Subscriber;

public class MainViewModel {
  public ObservableField<String> exception;
  private Subscriber<Result> subscriber;
  private NewsAdapter newsAdapter;

  public MainViewModel(NewsAdapter newsAdapter) {
    this.newsAdapter = newsAdapter;

    initData();
    getNews();
  }

  private void getNews() {
    subscriber = new Subscriber<Result>() {
      @Override
      public void onCompleted() {
        Log.d("[MainViewModel]", "onCompleted");
      }

      @Override
      public void onError(Throwable e) {

        exception.set(e.getMessage());
      }

      @Override
      public void onNext(Result resultModel) {
        newsAdapter.addItem(resultModel);
      }
    };
    RetrofitHelper.getInstance().getNews(subscriber);
  }

  private void initData() {
    exception = new ObservableField<>();
  }
}
