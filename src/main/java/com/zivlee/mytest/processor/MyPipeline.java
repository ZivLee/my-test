package com.zivlee.mytest.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description
 * 自定义对爬取的数据进行处理
 * @author: ZivLee
 * @date: 2019/1/17 22:36
 * @className: MyPipeline
 * @version: V1.0.0
*/
public class MyPipeline implements Pipeline {
    private Logger logger = LoggerFactory.getLogger(FirstProcessor.class);



    public void process(ResultItems resultItems, Task task) {
        String title = resultItems.get("title").toString();
        String parentTitle = resultItems.get("parentTitle").toString();
        String content = resultItems.get("content").toString();
//        StringBuilder msg = new StringBuilder(content);
//        int i = msg.indexOf("src=\"/assets1");
//        msg.insert(i-8,"http://www.funtl.com");
        String message;
        message = content.replace("src=\"/assets1","src=\"http://www.funtl.com/assets1");
        message = message.replace(" &lt;"," <");
        message = message.replace("&lt;/","</ ");
        message = message.replace("&gt;",">");
        message = message.replaceAll("<svg(([\\s\\S])*?)<\\/svg>"," ");
        message = message.replaceAll("<div class=\"line-numbers-wrapper\"(([\\s\\S])*?)<\\/div>"," ");

//        Object pic = resultItems.get("picture");
//        String picture = null;
//        if(pic != null){
//            picture = pic.toString();
//        }

        String url = "D:\\data\\webmagic\\Docker\\"+FirstProcessor.number+"_"+ parentTitle;
        File dir = new File(url);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(url+"\\"+title+".md");//保存文件地址
        try(FileOutputStream fop = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = message.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
