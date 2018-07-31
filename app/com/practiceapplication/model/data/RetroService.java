package app.com.practiceapplication.model.data;


import java.util.List;

import app.com.practiceapplication.model.NewsResponseModel;
import app.com.practiceapplication.model.Result;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Taruna on 2018/5/19.
 */
public interface RetroService {
    String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/";

    @Headers("api-key: 723c328f896141eda6c9d55052a49d6b")
    @GET("all-sections/7.json")
    Observable<NewsResponseModel<List<Result>>> getNews();
}
