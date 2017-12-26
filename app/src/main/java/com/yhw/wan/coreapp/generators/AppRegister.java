package com.yhw.wan.coreapp.generators;


import com.yhw.wan.annotations.AppRegisterGenerator;
import com.yhw.wan.core.wechat.templates.AppRegisterTemplate;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.yhw.wan.coreapp",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
