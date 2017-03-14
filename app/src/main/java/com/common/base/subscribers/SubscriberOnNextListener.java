package com.common.base.subscribers;

/**
 * Created by pz on 2017/03/03.
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}
