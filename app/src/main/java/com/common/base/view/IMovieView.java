package com.common.base.view;

/**
 * Created by pz on 2017/03/02.
 */

public interface IMovieView {

        void showLoading();
        void cancelLoading();
        void setStartNum(int start);
        void setCountNum(int countNum);
        int getStartNum();
        int getCountNum();
        void seachSucess();
        void searchFail();

        void setMovieTitle(String title);
}
