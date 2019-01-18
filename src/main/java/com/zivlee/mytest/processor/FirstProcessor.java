package com.zivlee.mytest.processor;

import com.zivlee.mytest.MyProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * @description
 * 第一层爬取
 * @author: ZivLee
 * @date: 2019/1/17 22:37
 * @className: FirstProcessor
 * @version: V1.0.0
 */
public class FirstProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Override
    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().xpath("//*[@id=\"app\"]/div/div[3]/div[1]/p/a/@href").all());
        List<String> list = page.getHtml().xpath("//*[@id=\"app\"]/div/div[3]/div[1]/p/a/@href").all();
        for (String url : list) {
            System.out.println("路经："+url);
            MyProcessor.getData("http://www.funtl.com"+url,new SecondProcessor(),new MyPipeline());
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
