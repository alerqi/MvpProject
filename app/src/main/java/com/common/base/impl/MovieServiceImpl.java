package com.common.base.impl;

import com.common.base.Bean.Subject;
import com.common.base.api.IMovieService;
import com.common.base.common.RetrofitUtil;
import com.common.base.common.ServiceUtil;
import com.common.base.listener.MovieOnListener;
import com.common.base.model.HttpResultEntity;
import com.common.base.subscribers.ProgressSubscriber;

import java.util.List;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by pz on 2017/03/03.
 */

public class MovieServiceImpl implements IMovieService {

    IMovieService iMovieService;
    MovieOnListener movieOnListener;

    public MovieServiceImpl(MovieOnListener movieOnListener) {
        this.movieOnListener = movieOnListener;
    }
    @Override
    public Observable<HttpResultEntity<List<Subject>>> searchMovie(@Query("start") int start, @Query("count") int count) {
        IMovieService movieService=ServiceUtil.getInstance().getMovieService();
        Observable observable=movieService.searchMovie(start,count);

        observable.
                subscribeOn(Schedulers.io())// 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<HttpResultEntity<List<Subject>>>() {
                    @Override
                    public void call(HttpResultEntity<List<Subject>> listHttpResultEntity) {
                        movieOnListener.onSucess(listHttpResultEntity);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        movieOnListener.onFailure(throwable);
                    }
                });

        return observable;
    }


}
