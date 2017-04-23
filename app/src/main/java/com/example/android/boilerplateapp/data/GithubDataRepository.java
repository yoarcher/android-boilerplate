package com.example.android.boilerplateapp.data;

import com.example.android.boilerplateapp.data.model.Event;
import com.example.android.boilerplateapp.data.remote.GithubService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yuanyou.
 */
@Singleton
public class GithubDataRepository {

    private GithubService githubService;
    private boolean isCacheDirty = true;
    private Map<String, Event> cachedEvents = new LinkedHashMap<>();

    @Inject
    public GithubDataRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    public Observable<List<Event>> getPublicEvents() {
        List<Event> events = new ArrayList<>(cachedEvents.values());
        if (!isCacheDirty) {
            Collections.sort(events, EVENT_COMPARATOR);
            return Observable.just(events);
        }
        cachedEvents.clear();
        return githubService
                .getPublicEvents(0)
                .subscribeOn(Schedulers.io())
                .concatMap(new Function<List<Event>, ObservableSource<Event>>() {
                    @Override
                    public ObservableSource<Event> apply(List<Event> events) throws Exception {
                        return Observable.fromIterable(events);
                    }
                })
                .doOnNext(new Consumer<Event>() {
                    @Override
                    public void accept(Event event) throws Exception {
                        cachedEvents.put(event.getId(), event);
                    }
                })
                .toSortedList(EVENT_COMPARATOR)
                .toObservable()
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        isCacheDirty = false;
                    }
                })
                .subscribeOn(Schedulers.computation());
    }

    public void refreshTasks() {
        isCacheDirty = true;
    }

    private final static Comparator<Event> EVENT_COMPARATOR = new Comparator<Event>() {
        @Override
        public int compare(Event o1, Event o2) {
            return o2.getCreatedAt().compareTo(o1.getCreatedAt());
        }
    };
}
