package com.zivlee.mytest.processor;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
/**
 * @description
 * 对数据不做任何处理
 * @author: ZivLee
 * @date: 2019/1/17 22:38
 * @className: NullPipeline
 * @version: V1.0.0
*/
public class NullPipeline implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        return;
    }
}
