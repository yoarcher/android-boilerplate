package com.example.android.boilerplateapp.ui.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.android.databinding.library.baseAdapters.BR;
import com.example.android.boilerplateapp.MyApplication;
import com.example.android.boilerplateapp.data.GithubDataRepository;
import com.example.android.boilerplateapp.data.model.Event;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by yuanyou.
 */

public class MainFragViewModel extends BaseObservable {

    public final ObservableField<MainAdapter> adapter = new ObservableField<>();
    public final ObservableBoolean dataLoading = new ObservableBoolean(false);

    @Inject
    GithubDataRepository dataRepository;

    @NonNull
    private CompositeDisposable disposables;

    @Inject
    public MainFragViewModel() {
        MyApplication.getApplication().getAppComponent().inject(this);
        disposables = new CompositeDisposable();
        adapter.set(new MainAdapter());
    }

    @Bindable
    public boolean isEmpty() {
        return adapter.get().getItemCount() == 0;
    }

    public void start() {
        loadEvents(false);
    }

    private void loadEvents(boolean forceUpdate) {
        loadEvents(forceUpdate, true);
    }

    private void loadEvents(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            dataLoading.set(true);
        }
        if (forceUpdate) {
            dataRepository.refreshTasks();
        }

        disposables.clear();
        Disposable disposable = dataRepository.getPublicEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Event>>() {
                    @Override
                    public void accept(List<Event> events) throws Exception {
                        processEvents(events);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onDataChanged();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        onDataChanged();
                    }
                });

        disposables.add(disposable);
    }

    private void processEvents(@NonNull List<Event> events) {
        if (events.isEmpty()) {
            // Show a message indicating there are no tasks for that filter type.
        }
        adapter.get().replaceData(events);
    }

    private void onDataChanged() {
        dataLoading.set(false);
        notifyPropertyChanged(BR.empty);
    }
}
