package hxm.time;


import hxm.article.Pa_in;
import hxm.config;

import java.util.TimerTask;

public class MyTask extends TimerTask {

    @Override
    public void run() {
        if (config.task_status){
            System.out.println("自动爬虫开始爬取：----------------------");
            Pa_in.sd();
        }else {
            System.out.println("爬虫关闭");
        }



    }

}