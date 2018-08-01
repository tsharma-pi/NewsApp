package app.com.practiceapplication.model.data;

import app.com.practiceapplication.model.NewsResponseModel;
import app.com.practiceapplication.model.Result;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RetrofitHelper {
  private static final int DEFAULT_TIMEOUT = 10;
  private Retrofit retrofit;
  private RetroService newsService;
  OkHttpClient.Builder builder;

  /**
   * RetrofitHelper
   */
  private static class Singleton {
    private static final RetrofitHelper INSTANCE = new RetrofitHelper();
  }

  public static RetrofitHelper getInstance() {
    return Singleton.INSTANCE;
  }

  private RetrofitHelper() {

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    builder = new OkHttpClient.Builder().addInterceptor(interceptor);
    builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    retrofit = new Retrofit.Builder()
        .client(builder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(RetroService.BASE_URL)
        .build();
    newsService = retrofit.create(RetroService.class);
  }

  public void getNews(Subscriber<Result> subscriber) {
    newsService.getNews().map(new Func1<NewsResponseModel<List<Result>>, List<Result>>() {

      @Override
      public List<Result> call(NewsResponseModel<List<Result>> listNewsResponseModel) {
        return listNewsResponseModel.getResults();
      }
    })
        .flatMap(new Func1<List<Result>, Observable<Result>>() {
          @Override
          public Observable<Result> call(List<Result>  resultModels) {
            return Observable.from(resultModels);
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber);
  }
}
