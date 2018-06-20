package com.yhw.wan.core.pay;

/**
 * Created by 刘世波
 */

public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();
}
