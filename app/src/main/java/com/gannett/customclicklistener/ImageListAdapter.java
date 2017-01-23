package com.gannett.customclicklistener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static android.view.View.inflate;

/**
 * Created by agore on 1/17/17.
 */

public class ImageListAdapter extends RecyclerView.Adapter {

    public static final String[] images = new String[] {
            "http://res.cloudinary.com/gannett-usatoday/image/upload/c_fit,w_640/v1478273932/v0hpqjdh8fnqvggxranj.jpg",
            "http://res.cloudinary.com/gannett-usatoday/image/upload/c_fit,w_640/v1478112135/sn15syf1dfnqdlz6xinc.jpg",
            "http://res.cloudinary.com/gannett-usatoday/image/upload/c_fit,h_480/v1478102765/isy629eyh0pzegxjqzv1.jpg",
            "http://res.cloudinary.com/gannett-usatoday/image/upload/c_fit,w_640/v1476803670/sample.jpg"
    };
    private Context context;

    public ImageListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.img_cell, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ImageView iv = ((ImageViewHolder) holder).iv;
        Glide.with(context).load(images[position]).fitCenter().into(iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.IMAGE_URL, images[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public ImageViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.img_cell);
        }
    }
}
