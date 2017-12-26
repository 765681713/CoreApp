package com.yhw.wan.ui.utils;

/**
 * Created by jieku02 on 2017/12/26.
 */

public class RxBusMsg<T> {
    public static final int REQUEST_ONE = 1;

    private int request;
    private String mMsg;
    private T data;

    private RxBusMsg(Builder<T> build) {
        this.request = build.request;
        this.mMsg = build.msg;
        this.data = build.data;
    }

    public String getMsg() {
        return mMsg;
    }

    public int getRequest() {
        return request;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RxBusMsg{" +
                "request=" + request +
                ", mMsg='" + mMsg + '\'' +
                ",data=" + data +
                '}';
    }

    public static class Builder<T> {

        private final int request;
        private T data;
        private String msg;

        public Builder(int request) {
            this.request = request;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public RxBusMsg<T> build() {
            return new RxBusMsg<>(this);
        }
    }
}