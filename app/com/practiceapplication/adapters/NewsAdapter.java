package app.com.practiceapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import app.com.practiceapplication.NewsDetailActivity;
import app.com.practiceapplication.R;
import app.com.practiceapplication.databinding.NewsItemBinding;
import app.com.practiceapplication.model.Result;
import app.com.practiceapplication.viewmodel.NewsViewModel;


/**
 * Created by Taruna on 2019/08/01.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.BindingHolder> {

    List <Result> resultModels;
    Context context;

    public NewsAdapter( Context context) {
        resultModels =  new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.news_item, parent, false);
        return new BindingHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, final int position) {
        NewsViewModel newsViewModel = new NewsViewModel(resultModels.get(position));
        holder.itemBinding.setViewModel(newsViewModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url =resultModels.get(position).getUrl();
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra(context.getString(R.string.url),url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultModels.size();
    }

    public void addItem(Result resultModel) {
        resultModels.add(resultModel);
        notifyItemInserted(resultModels.size() - 1);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private NewsItemBinding itemBinding;

        public BindingHolder(NewsItemBinding itemBinding) {
            super(itemBinding.cardView);
            this.itemBinding = itemBinding;
        }
    }
}
