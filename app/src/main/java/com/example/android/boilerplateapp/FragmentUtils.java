package com.example.android.boilerplateapp;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by yuanyou.
 */

public class FragmentUtils {

    public static void addFragment(@NonNull FragmentManager fragmentManager,
                                   @NonNull Fragment fragment,
                                   String tag) {
        fragmentManager
                .beginTransaction()
                .add(fragment, tag)
                .commit();
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment,
                                       int frameId, boolean addToStack) {
        FragmentTransaction transaction = fragmentManager
                .beginTransaction()
                .replace(frameId, fragment);
        if (addToStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
