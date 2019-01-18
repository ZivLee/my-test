package com.zivlee.mytest;

import com.zivlee.mytest.processor.FirstProcessor;
import com.zivlee.mytest.processor.NullPipeline;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyProcessor {
    /**
     * 爬数据
     */
    public static void main(String[] args){
//        MyPipeline myPipeline = new MyPipeline();
        NullPipeline nullPipeline = new NullPipeline();
        Spider.create(new FirstProcessor())
                .addUrl("http://www.funtl.com/zh/guide/Docs-docker.html")
                .addPipeline(nullPipeline)
                //设置Pipeline，将结果以json方式保存到文件
//                .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                .thread(5)
                .run();
    }


    /**
     *
     * @param url 初始入口url
     * @param processor 自定义的规则类
     * @param pipeline 自定义处理结果类
     */
    public static void getData(String url, PageProcessor processor, Pipeline pipeline) {
        Spider.create(processor)
                .addUrl(url)
                .addPipeline(pipeline)
                //设置Pipeline，将结果以json方式保存到文件
//                  .addPipeline(new JsonFilePipeline("D:\\data\\webmagic"))
                .thread(5)
                .run();
    }
}
