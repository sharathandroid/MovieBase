package com.example.shara.tmdb.Model.Adapter;

/**
 * Created by shara on 3/16/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.dalol.restapidemo.R;
import org.dalol.restapidemo.model.utilities.Constants;

import java.util.List;

import com.example.shara.tmdb.Model.POJO.Movies;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {

    public static String TAG = MovieAdapter.class.getSimpleName();

    private List<Movies> mMovies;

    public MovieAdapter(List<Movies> movies) {
        mMovies = movies;
    }

    public void addMovie(Movies movies) {
        mMovies.add(movies);
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new Holder(row);
    }

    
 

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Movies currentMovie = mMovies.get(position);
        holder.mName.setText(currentMovie.mName);
        holder.mCategory.setText(currentMovie.mCategory);
        holder.mPrice.setText(Double.toString(currentMovie.mPrice));
        holder.mInstructions.setText(currentMovie.mInstructions);

        Picasso.with(holder.itemView.getContext()).load(Constants.PHOTO_URL + currentMovie.mPhoto).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView mName, mCategory, mPrice, mInstructions;
        public ImageView mImage;

        public Holder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.flowerImage);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mCategory = (TextView) itemView.findViewById(R.id.flowerCategory);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice);
            mInstructions = (TextView) itemView.findViewById(R.id.flowerInstruction);
        }
    }
}
