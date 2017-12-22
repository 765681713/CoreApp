package com.yhw.wan.coreapp.event;

import com.yhw.wan.core.delegates.web.event.Event;
import com.yhw.wan.core.util.log.CoreLogger;

/**
 * Created by 傅令杰
 */

public class ShareEvent extends Event {

    @Override
    public String execute(String params) {
        CoreLogger.json("ShareEvent", params);
        return null;
    }
}
