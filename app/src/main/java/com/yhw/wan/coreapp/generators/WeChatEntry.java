package com.yhw.wan.coreapp.generators;


import com.yhw.wan.annotations.EntryGenerator;
import com.yhw.wan.core.wechat.templates.WXEntryTemplate;

/**
 * Created by 刘世波 on 2017/4/22
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.yhw.wan.coreapp",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
