package hxm.article;

import java.util.ArrayList;

public class Pa_in {

    public static void sd(){
        new Thread(){
            @Override
            public void run() {
                Pa ps=new Pa();
                ArrayList<Cj.csdn> cs=Cj.getData();
                for (int i=0;i<cs.size();i++){
                    String title=cs.get(i).title;
                    String content=cs.get(i).content;
                    ps.insert(title,content);

                }
            }
        }.start();

    }
}
