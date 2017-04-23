package com.example.android.boilerplateapp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.boilerplateapp.R;
import com.example.android.boilerplateapp.databinding.FragmentMainBinding;
import com.example.android.boilerplateapp.ui.common.BaseFragment;

/**
 * Created by yuanyou.
 */

public class MainFragment extends BaseFragment {

    private MainFragViewModel viewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflateAndDataBind(inflater, container, R.layout.fragment_main, viewModel);
        RecyclerView recyclerView = ((FragmentMainBinding) binding).recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.start();
    }

    public void setViewModel(MainFragViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
