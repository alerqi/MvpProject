package com.common.base.mvpproject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.common.base.persenter.MoviePersenter;
import com.common.base.view.IMovieView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMovieView {

    @Bind(R.id.edt_start)
    EditText edtStart;
    @Bind(R.id.edt_count)
    EditText edtCount;
    @Bind(R.id.btn_search)
    Button btnSearch;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    ProgressDialog pd;
    MoviePersenter moviePersenter;
    @Bind(R.id.txt_title)
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pd = new ProgressDialog(this);
        moviePersenter = new MoviePersenter(this);
    }


    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void cancelLoading() {
        pd.cancel();
    }

    @Override
    public void setStartNum(int start) {
        edtStart.setText(start + "");
    }

    @Override
    public void setCountNum(int countNum) {
        edtCount.setText(countNum + "");
    }

    @Override
    public int getStartNum() {
        return Integer.parseInt(edtStart.getText().toString());
    }

    @Override
    public int getCountNum() {
        return Integer.parseInt(edtCount.getText().toString());
    }

    @Override
    public void seachSucess() {
        Toast.makeText(MainActivity.this, "searchSucess", Toast.LENGTH_LONG).show();
        pd.show();
    }

    @Override
    public void searchFail() {
        Toast.makeText(MainActivity.this, "searchFail", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setMovieTitle(String title) {
        txtTitle.setText(title);
    }


    @OnClick(R.id.btn_search)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                moviePersenter.searchMovie(getStartNum(), getCountNum());
                //addSubscription(iMovieServiceImpl.getTopLoveMovie(0,10));
                break;
        }
    }


}
