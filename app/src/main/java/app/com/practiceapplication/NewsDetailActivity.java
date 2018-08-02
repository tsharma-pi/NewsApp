package app.com.practiceapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import app.com.practiceapplication.databinding.ActivityNewsDetailBinding;
import app.com.practiceapplication.viewmodel.NewsDetailViewModel;

public class NewsDetailActivity extends AppCompatActivity {

  ActivityNewsDetailBinding activityNewsDetailBinding;
  String url;

  public static NewsDetailActivity getInstance() {
    return new NewsDetailActivity();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    activityNewsDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);

    Intent intent = getIntent();
    url = intent.getStringExtra(getString(R.string.url));

    if (url != null) activityNewsDetailBinding.setViewModel(new NewsDetailViewModel(url));
  }

  public String getUrl() {
    return url;
  }
}
