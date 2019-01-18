package com.zivlee.mytest.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * @description
 * 基本爬取规则
 * @author: ZivLee
 * @date: 2019/1/17 22:37
 * @className: BaseProcessor
 * @version: V1.0.0
*/
public abstract class BaseProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public Site getSite() {
        return site;
    }
    protected void putField(Page page, String urlXpath){
        page.addTargetRequests(page.getHtml().xpath(urlXpath).all());
        page.putField("title", page.getHtml().xpath("//*[@id=\"app\"]/div/div[3]/div[1]/h1/@id"));
        //获取标签中所有的内容(包括标签)
        page.putField("content", page.getHtml().xpath("//*[@id=\"app\"]/div/div[3]/div[1]").toString());
        //获取该标签中所有标签的内容
        //page.putField("content", page.getHtml().xpath("//html/body/div[2]/section[2]/div/div/div/tidyText()").toString());
        //page.putField("picture", page.getHtml().xpath("//*[@id=\"app\"]/div/div[3]/div[1]/p/img/@src").toString());
        if (page.getResultItems().get("title") == null) {
            //跳过没有数据的页面
            page.setSkip(true);
        }
        if (page.getResultItems().get("content")==null){
            //skip this page
            page.setSkip(true);
        }
    }
}
