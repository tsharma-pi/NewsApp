package app.com.practiceapplication.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import app.com.practiceapplication.model.NewsResponseModel;
import app.com.practiceapplication.model.ResultModel;

public class NewsViewModel extends BaseObservable {

  ResultModel resultModel;

    public NewsViewModel(ResultModel resultModel) {
        this.resultModel = resultModel;
    }

    public String getTitle(){
        return resultModel.getTitle();
    }

    public String ppublishedDate(){

        return resultModel.getPublishedDate();
    }

    public String getByLine(){
        return resultModel.getByline();
    }

}
