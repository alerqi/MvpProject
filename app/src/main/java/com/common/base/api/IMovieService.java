package com.common.base.api;

import com.common.base.Bean.Subject;
import com.common.base.model.HttpResultEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pz on 2017/03/02.
 */

public interface IMovieService {

    @GET("top250")
    Observable<HttpResultEntity<List<Subject>>> searchMovie(@Query("start") int start, @Query("count") int count);

}
