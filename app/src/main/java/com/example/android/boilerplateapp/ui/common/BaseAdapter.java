package com.example.android.boilerplateapp.ui.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

/**
 * Created by yuanyou.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ItemViewHolder<T>> {

    protected List<T> items;
    protected LayoutInflater inflater;

    public BaseAdapter(@NonNull List<T> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getLayoutIdForViewType(viewType),
                parent, false);
        return new ItemViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder<T> holder, int position) {
        T item = getItemAtPosition(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void replaceData(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    protected T getItemAtPosition(int position) {
        return items.get(position);
    }

    @LayoutRes
    protected abstract int getLayoutIdForViewType(int viewType);

    /**
     * Created by yuanyou.
     */

    public static class ItemViewHolder<T> extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public ItemViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(T item) {
            binding.setVariable(BR.item, item);
            binding.executePendingBindings();
        }
    }
}
