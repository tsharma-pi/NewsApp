package app.com.practiceapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import app.com.practiceapplication.adapters.NewsAdapter;
import app.com.practiceapplication.databinding.ActivityNewsBinding;
import app.com.practiceapplication.viewmodel.MainViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.newsRecylerView)
    RecyclerView newsRecylerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NewsAdapter newsAdapter;
    MainViewModel viewModel;
    ActivityNewsBinding activityNewsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        newsAdapter = new NewsAdapter(this);
        activityNewsBinding.newsRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        activityNewsBinding.newsRecylerView.setItemAnimator(new DefaultItemAnimator());
        activityNewsBinding.newsRecylerView.setAdapter(newsAdapter);
        viewModel = new MainViewModel(newsAdapter);
        activityNewsBinding.setViewModel(viewModel);

    }

}
