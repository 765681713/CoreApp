package com.yhw.wan.ui.utils;

import android.support.annotation.NonNull;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by jieku02 on 2017/12/26.
 */

public class RxBus {

    private final FlowableProcessor<Object> mBus;

    private RxBus() {
        mBus = PublishProcessor.create().toSerialized();
    }

    private static class Holder {
        private static RxBus instance = new RxBus();
    }

    public static RxBus getInstance() {
        return Holder.instance;
    }

    public <T> void post(@NonNull RxBusMsg<T> msg) {
        mBus.onNext(msg);
    }

    public Flowable<RxBusMsg> register() {
        return mBus.ofType(RxBusMsg.class);
    }

    public void unregisterAll() {
        //会将所有由mBus生成的Flowable都置completed状态后续的所有消息都收不到了
        mBus.onComplete();
    }

}
