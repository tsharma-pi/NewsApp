package app.com.practiceapplication.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import app.com.practiceapplication.R;
import app.com.practiceapplication.databinding.NewsItemBinding;
import app.com.practiceapplication.model.NewsResponseModel;
import app.com.practiceapplication.model.ResultModel;
import app.com.practiceapplication.viewmodel.NewsViewModel;


/**
 * Created by Taruna on 2019/5/19.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.BindingHolder> {

    List <ResultModel> resultModels;
    Context context;

    public NewsAdapter(List<ResultModel> resultModels, Context context) {
        this.resultModels = resultModels;
        this.context = context;
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.news_item, parent, false);
        return new BindingHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {
        NewsViewModel newsViewModel = new NewsViewModel(resultModels.get(position));
        holder.itemBinding.setViewModel(newsViewModel);
    }

    @Override
    public int getItemCount() {
        return resultModels.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private NewsItemBinding itemBinding;

        public BindingHolder(NewsItemBinding itemBinding) {
            super(itemBinding.cardView);
            this.itemBinding = itemBinding;
        }
    }
}
