package com.yhw.wan.coreapp.generators;


import com.yhw.wan.annotations.PayEntryGenerator;
import com.yhw.wan.core.wechat.templates.WXPayEntryTemplate;

/**
 * Created by 刘世波 on 2017/4/22
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.yhw.wan.coreapp",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
