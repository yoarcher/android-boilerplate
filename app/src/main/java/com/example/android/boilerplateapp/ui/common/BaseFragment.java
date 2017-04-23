package com.example.android.boilerplateapp.ui.common;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by yuanyou.
 */

public class BaseFragment extends RxFragment {

    protected ViewDataBinding binding;

    protected View inflateAndDataBind(LayoutInflater inflater, ViewGroup container,
                                      @LayoutRes int layoutId,
                                      @NonNull BaseObservable viewModel) {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        binding.setVariable(BR.viewModel, viewModel);
        return binding.getRoot();
    }
}
