package com.common.base.listener;

import com.common.base.Bean.Subject;
import com.common.base.model.HttpResultEntity;

import java.util.List;

/**
 * Created by pz on 2017/03/02.
 */

public interface MovieOnListener {

    void onSucess(HttpResultEntity<List<Subject>> resultEntity);

    void onFailure(Throwable throwable);

}
