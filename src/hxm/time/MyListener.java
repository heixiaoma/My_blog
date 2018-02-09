package hxm.time;

import hxm.config;

import java.util.Calendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    private static Timer timer;
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        timer.cancel();
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (timer == null) {
            Calendar calendar = Calendar.getInstance();
            timer = new Timer();
            timer.schedule(new MyTask(), calendar.getTime(), config.period);
        }
    }

}