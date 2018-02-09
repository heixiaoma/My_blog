package hxm.article;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cj {
    public static ArrayList<csdn> data=new ArrayList<>();
    public static ArrayList<csdn> getData(){
        data.clear();
        new Cj().get_Title();
        return data;
    }

    public void get_Title(){
        String res = httpRequest("https://www.oschina.net/blog");
        Pattern p = Pattern.compile("<header class=\"box vertical blog-title-box\">(.*?)</a>");
        Matcher m = p.matcher(res);
        while (m.find()) {
            Matcher ms = Pattern.compile("(<a(.*?)>.*?</a>)", Pattern.DOTALL).matcher(m.group());
            if (ms.find())
            {
                String re=ms.group();
                int a=re.indexOf("href=\"");
                int b=re.indexOf("\"",a+10);
                String url=re.substring(a+6,b);
                int c=re.indexOf("title=");
                int d=re.indexOf("\">",c);
                String title=re.substring(c+7,d).trim();
                System.out.println("标题："+title+"地址："+url);
                csdn cs=new csdn();
                cs.title=title;
                cs.content=get_Wz(url);
//                System.out.println(cs.content);
                data.add(cs);
            }
        }
    }

    //模拟浏览器执行获取解析后的html
    public String get_Wz(String url){
        try {

            final WebClient mWebClient = new WebClient(BrowserVersion.CHROME);
                mWebClient.getOptions().setCssEnabled(false);
                mWebClient.getOptions().setJavaScriptEnabled(false);
            final HtmlPage mHtmlPage = mWebClient.getPage(url);
            HtmlDivision hd  = mHtmlPage.getHtmlElementById("blogBody");
//                System.out.println(mHtmlPage.asXml());
            return hd.asXml();

        }catch (Exception r){
        }
        return "";

    }
    private String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.addRequestProperty("Content-Type","text/html; charset=UTF-8");
            httpUrlConn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return buffer.toString();
    }

    public class csdn{
        public String title;
        public String content;
    }

}
