package com.common.base.common;

import com.common.base.api.IMovieService;

/**
 * Created by pz on 2017/03/03.
 */

public class ServiceUtil {


    private static final ServiceUtil serviceUtil=new ServiceUtil();

    private ServiceUtil(){
    }

    public static ServiceUtil getInstance(){
        return  serviceUtil;
    }

    public IMovieService getMovieService(){
        IMovieService iMovieService=RetrofitUtil.getmInstance().retrofit.create(IMovieService.class);
        return  iMovieService;
    }


}
