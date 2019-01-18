package com.zivlee.mytest.processor;

import us.codecraft.webmagic.Page;

/**
 * @description
 * 第二层爬数据
 * @author: ZivLee
 * @date: 2019/1/17 22:42
 * @className: SecondProcessor
 * @version: V1.0.0
*/
public class SecondProcessor extends BaseProcessor {

    public void process(Page page) {
        putField(page,"//*[@id=\"app\"]/div/div[2]/ul/li/div/ul/li/a/@href");
    }
}
