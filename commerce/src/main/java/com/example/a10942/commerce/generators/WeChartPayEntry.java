package com.example.a10942.commerce.generators;


import com.diabin.latte.wechat.templates.WXPayEntryTemplate;
import com.example.annotations.PayEntryGenerator;

/**
 * Created by User on 2017/8/20.
 */
@PayEntryGenerator(
        packageName = "com.ec.example", payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChartPayEntry {
}
