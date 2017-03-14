package com.common.base.persenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pz on 2017/03/02.
 */

public class BasePersenter {

    private CompositeSubscription compositeSubscription;

    /***
     * RXjava取消注册，以避免内存泄露
     */
    public void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }


    /***
     * RXjava注册
     *
     * @param subscriber
     */
    public void addSubscription(Subscription subscriber) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscriber);
    }
}
