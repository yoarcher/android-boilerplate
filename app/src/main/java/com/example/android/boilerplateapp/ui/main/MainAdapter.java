package com.example.android.boilerplateapp.ui.main;

import android.support.annotation.LayoutRes;

import com.example.android.boilerplateapp.R;
import com.example.android.boilerplateapp.data.model.Event;
import com.example.android.boilerplateapp.ui.common.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by yuanyou.
 */

public class MainAdapter extends BaseAdapter<Event> {

    public MainAdapter() {
        super(new ArrayList<Event>());
    }

    @Override
    @LayoutRes
    protected int getLayoutIdForViewType(int viewType) {
        return R.layout.item_event_card;
    }
}
