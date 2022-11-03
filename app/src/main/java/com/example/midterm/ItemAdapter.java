package com.example.midterm;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    String title[],rate[],price[],description[],trailer[];
    int mvImage[];
    Context context;

    //Intent favItent = new Intent(this,)

    public ItemAdapter(Context ct,String titles[],String rates[],String prices[],String descriptions[],String trailers[],int mvImages[]){
        context = ct;
        title = titles;
        rate = rates;
        price = prices;
        description = descriptions;
        mvImage = mvImages;
        trailer = trailers;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.tvTitle.setText(title[position]);
        holder.tvRating.setText(rate[position]);
        holder.tvPrice.setText(price[position]);
        holder.movieIV.setImageResource(mvImage[position]);

        int temp = position;
        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("title",title[temp]);
                intent.putExtra("rate",rate[temp]);
                intent.putExtra("price",price[temp]);
                intent.putExtra("description",description[temp]);
                intent.putExtra("image",mvImage[temp]);
                intent.putExtra("trailer",trailer[temp]);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rate.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle,tvRating,tvPrice;
        ImageView movieIV;
        ConstraintLayout item_layout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.movie_tilte_text);
            tvPrice = itemView.findViewById(R.id.price_text);
            tvRating = itemView.findViewById(R.id.rating_text);
            movieIV = itemView.findViewById(R.id.mv_image);
            item_layout = itemView.findViewById(R.id.item_layout);
        }
    }

    //public void start



}
