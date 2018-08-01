package app.com.practiceapplication.model.data;

import app.com.practiceapplication.model.NewsResponseModel;
import app.com.practiceapplication.model.Result;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

public interface RetroService {
  String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/";

  @Headers("api-key: 723c328f896141eda6c9d55052a49d6b")
  @GET("all-sections/7.json") Observable<NewsResponseModel<List<Result>>> getNews();
}
