package com.example.topratedmovies;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    int i;
    Context context;
    TopRated topRatedList;
    String imageSize = "https://www.themoviedb.org/t/p/w220_and_h330_face";

    public MyAdapter(Context context, TopRated topRatedList) {
        this.context = context;
        this.topRatedList = topRatedList;
    }

    public void setMovieList(TopRated topRatedList) {
        this.topRatedList = topRatedList;
        notifyDataSetChanged();
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Collections.sort(topRatedList.getResults(), new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m2.getRate().compareTo(m1.getRate());
            }
        });

        List<Movie> listMovie = new ArrayList<>();
        for(i=0;i<10;i++) {
            listMovie.add(topRatedList.getResults().get(i));
        }
        topRatedList.setResults(listMovie);

        holder.tvMovieName.setText(topRatedList.getResults().get(position).getOriginalTitle());
        Glide.with(context).load(imageSize + topRatedList.getResults().get(position)
                .getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);
        holder.tvRate.setText(topRatedList.getResults().get(position).getRate());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("pelicula_seleccionada", topRatedList.getResults().get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(topRatedList != null){
            return topRatedList.getResults().size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        ImageView image;
        TextView tvRate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView)itemView.findViewById(R.id.tvOriginalTitle);
            image = (ImageView)itemView.findViewById(R.id.ivImage);
            tvRate = (TextView)itemView.findViewById(R.id.tvRate);
        }
    }

}
