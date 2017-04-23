package com.example.android.boilerplateapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.android.boilerplateapp.MyApplication;
import com.example.android.boilerplateapp.FragmentUtils;
import com.example.android.boilerplateapp.R;
import com.example.android.boilerplateapp.ui.common.BaseActivity;
import com.example.android.boilerplateapp.ui.common.ViewModelHolder;

/**
 * Created by yuanyou.
 */

public class MainActivity extends BaseActivity {

    private final static String TAG_MAIN_FRAG_VIEWMODEL = "TAG_MAIN_FRAG_VIEWMODEL";

    private MainFragViewModel mainFragViewModel;

    public static Intent createIntent() {
        return new Intent(MyApplication.getApplication(), MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();

        MainFragment mainFragment = findOrCreateViewFragment();
        mainFragViewModel = findOrCreateViewModel();

        // Link View and ViewModel
        mainFragment.setViewModel(mainFragViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private MainFragViewModel findOrCreateViewModel() {
        // In a configuration change we might have a ViewModel present. It's retained using the
        // Fragment Manager.
        @SuppressWarnings("unchecked")
        ViewModelHolder<MainFragViewModel> retainedViewModel =
                (ViewModelHolder<MainFragViewModel>) getSupportFragmentManager()
                        .findFragmentByTag(TAG_MAIN_FRAG_VIEWMODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            // If the model was retained, return it.
            return retainedViewModel.getViewModel();
        } else {
            // There is no ViewModel yet, create it.
            MainFragViewModel viewModel = new MainFragViewModel();
            // and bind it to this Activity's lifecycle using the Fragment Manager.
            FragmentUtils.addFragment(
                    getSupportFragmentManager(),
                    ViewModelHolder.createInstance(viewModel),
                    TAG_MAIN_FRAG_VIEWMODEL);
            return viewModel;
        }
    }

    @NonNull
    private MainFragment findOrCreateViewFragment() {
        MainFragment mainFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            // Create the fragment
            mainFragment = MainFragment.newInstance();
            FragmentUtils.replaceFragment(
                    getSupportFragmentManager(), mainFragment, R.id.contentFrame, false);
        }
        return mainFragment;
    }
}
