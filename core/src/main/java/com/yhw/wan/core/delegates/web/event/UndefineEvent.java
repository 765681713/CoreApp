package com.yhw.wan.core.delegates.web.event;


import com.yhw.wan.core.utils.CoreLogger;

/**
 * Created by 傅令杰
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        CoreLogger.e("UndefineEvent", params);
        return null;
    }
}
