package hxm.article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class articles {
    private int id;
    private String title;
    private String content;
    private  String time;
    private String dw;
    private String time_y;
    private String time_m;
    private String src;
    public articles(int id,String title,String content,String time){
        this.id=id;
        this.title=title;
        this.content=content;
        this.time=time;
        if (delHtmlTag(content).length()>=120) {
            this.dw =  delHtmlTag(content).substring(0, 120) + "...";
        }else {
            this.dw=delHtmlTag(content);
        }
        try {
            this.time_y=time.substring(0,4);
            this.time_m=time.substring(5,time.length());
        }catch (Exception e){
            this.time_m="01-01";
            this.time_y="2017";
        }
        this.src=getSrc_url(content);

    }
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getTime() {
        return time;
    }
    public String getTitle() {
        return title;
    }
    public String getDw() {
        return dw;
    }
    public String getTime_y() {
        return time_y;
    }
    public String getTime_m() {
        return time_m;
    }
    public String getSrc() {
        return src;
    }
    //去除标签
    public static String delHtmlTag(String str){
        Document doc = Jsoup.parse(str);
        String text = doc.text();
        // remove extra white space
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while(builder.length()>index){
            char tmp = builder.charAt(index);
            if(Character.isSpaceChar(tmp) || Character.isWhitespace(tmp)){
                builder.setCharAt(index, ' ');
            }
            index++;
        }
        text = builder.toString().replaceAll(" +", " ").trim();
        return text;
    }
    //获取src
    public static String  getSrc_url(String args) {
        try {
            Document doc = Jsoup.parse(args);
            //获取 带有src属性的img元素
            Elements imgTags = doc.select("img[src]");
            for (Element element : imgTags) {
                String src2 = element.attr("src");//获取src的绝对路径
                return src2;
            }
        }catch (Exception e){

        }
        return "../web/images/t03.jpg";
    }
}
