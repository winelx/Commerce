package com.example.a10942.commerce.generators;


import com.diabin.latte.wechat.templates.WXEntryTemplate;
import com.example.annotations.AppRegisterGenerator;

/**
 * Created by User on 2017/8/20.
 */
@AppRegisterGenerator(
        packageName = "com.ec.example", registerTemplate = WXEntryTemplate.class
)
public interface AppRegisterEntry {
}
