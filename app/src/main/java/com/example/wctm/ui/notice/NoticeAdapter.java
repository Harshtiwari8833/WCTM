package com.example.wctm.ui.notice;

import android.annotation.SuppressLint;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wctm.FullImageView;
import com.example.wctm.R;


import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NotiveViewAdapter> {
    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotiveViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);

        return new NotiveViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiveViewAdapter holder, @SuppressLint("RecyclerView") int position) {
        NoticeData currentItem = list.get(position);
        holder.NoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null) {
                Glide.with(context).load(currentItem.getImage()).into(holder.NoticeImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.NoticeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image", currentItem.getImage());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotiveViewAdapter extends RecyclerView.ViewHolder {

        private TextView NoticeTitle, date, time;
        private ImageView NoticeImage;

        public NotiveViewAdapter(@NonNull View itemView) {
            super(itemView);
            NoticeTitle = itemView.findViewById(R.id.NoticeTitle);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

            NoticeImage = itemView.findViewById(R.id.NoticeImage);
        }
    }
}

