package com.yhw.wan.core.delegates.web.event;


import com.yhw.wan.core.util.log.LatteLogger;

/**
 * Created by 傅令杰
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }
}
