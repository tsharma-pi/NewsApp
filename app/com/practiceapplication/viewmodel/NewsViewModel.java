package app.com.practiceapplication.viewmodel;

import android.databinding.BaseObservable;
import app.com.practiceapplication.model.Result;

public class NewsViewModel extends BaseObservable {

  Result resultModel;

    public NewsViewModel(Result resultModel) {
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
