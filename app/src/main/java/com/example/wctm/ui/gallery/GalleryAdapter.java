package com.example.wctm.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wctm.FullImageView;
import com.example.wctm.R;

import java.util.List;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {
private Context context;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    private List<String>  images;




    @NonNull
    @Override
    public GalleryAdapter.GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);


        return new GalleryViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryViewAdapter holder, int position) {
        Glide.with(context).load(images.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {

ImageView imageView;
        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);
imageView = itemView.findViewById(R.id.image);
        }
    }
}
