package app.com.practiceapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import app.com.practiceapplication.NewsDetailActivity;
import app.com.practiceapplication.R;
import app.com.practiceapplication.databinding.NewsItemBinding;
import app.com.practiceapplication.model.Result;
import app.com.practiceapplication.viewmodel.NewsViewModel;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Taruna on 2018/08/01.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.BindingHolder> {

    List <Result> resultModels;
    Context context;

    public NewsAdapter(Context context) {
        this.resultModels = new ArrayList<>();
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
            @Override public void onClick(View view) {
              //sending url to be shown in NewsDetailActivity
                String url = resultModels.get(position).getUrl();
                if(url!=null) {
                  Intent intent = new Intent(context, NewsDetailActivity.class);
                  intent.putExtra(context.getString(R.string.url), url);
                  context.startActivity(intent);
                }else Toast.makeText(context, R.string.no_content_for_this_news,Toast.LENGTH_SHORT).show();
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
