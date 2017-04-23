package com.example.android.boilerplateapp.ui.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by yuanyou.
 */

public class ViewModelHolder<T> extends Fragment {

    private T viewModel;

    public ViewModelHolder() {
    }

    public static <VM> ViewModelHolder createInstance(@NonNull VM viewModel) {
        ViewModelHolder<VM> holder = new ViewModelHolder<>();
        holder.setViewModel(viewModel);
        return holder;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(@NonNull T viewModel) {
        this.viewModel = viewModel;
    }
}
