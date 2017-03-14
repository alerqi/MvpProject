package com.common.base.persenter;

import com.common.base.Bean.Subject;
import com.common.base.api.IMovieService;
import com.common.base.common.RetrofitUtil;
import com.common.base.impl.MovieServiceImpl;
import com.common.base.listener.MovieOnListener;
import com.common.base.model.HttpResultEntity;
import com.common.base.subscribers.ProgressSubscriber;
import com.common.base.view.IMovieView;

import java.util.List;

/**
 * Created by pz on 2017/03/02.
 */
public class MoviePersenter extends BasePersenter implements MovieOnListener {


    IMovieView iMovieView;
    MovieServiceImpl  movieServiceImpl;

    public MoviePersenter(IMovieView iMovieView) {
        this.iMovieView = iMovieView;
        movieServiceImpl=new MovieServiceImpl(this);
    }


    public void searchMovie(int start, int count) {
        int startNum = iMovieView.getStartNum();
        int countNum = iMovieView.getCountNum();
        movieServiceImpl.searchMovie(0, 10);
    }


    @Override
    public void onSucess(HttpResultEntity<List<Subject>> resultEntity) {
        iMovieView.cancelLoading();
        iMovieView.setMovieTitle(resultEntity.getTitle());
    }

    @Override
    public void onFailure(Throwable throwable) {
        iMovieView.cancelLoading();
    }
}
