package com.example.android.boilerplateapp.ui.common;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.android.boilerplateapp.data.model.Actor;

/**
 * Created by yuanyou.
 */

public class BindingAdapters {

    @BindingAdapter("adapter")
    public static <T> void setAdapter(RecyclerView view, BaseAdapter<T> adapter) {
        if (adapter != null) {
            view.setAdapter(adapter);
        }
    }

    @BindingAdapter("actor_image")
    public static void setAvatarImage(ImageView imageView, Actor actor) {
        Glide.with(imageView.getContext())
                .load(actor.getAvatarUrl())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(imageView);
    }
}
