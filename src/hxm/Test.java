package hxm;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import hxm.article.Cj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] xxx)
    {
        new Cj().get_Title();
        //getFormatDate();
       // System.out.println(get_Wz("http://blog.csdn.net/qq_34137397/article/details/72837353"));
//        get_Title();

    }

    public String getContenthtml(String url){
        try {

            final WebClient mWebClient = new WebClient(BrowserVersion.CHROME);
//                mWebClient.getOptions().setCssEnabled(false);
//                mWebClient.getOptions().setJavaScriptEnabled(false);
            final HtmlPage mHtmlPage = mWebClient.getPage(url);
            //从[烟雨林博客]上获取标签hed的内容

            return (mHtmlPage.asXml());

        }catch (Exception r){
        }
        return "";

    }
    private static void get_Title(){
        String res = httpRequest("https://www.oschina.net/blog");
        Pattern p = Pattern.compile("<header class=\"box vertical blog-title-box\">(.*?)</a>");
        Matcher m = p.matcher(res);
        while (m.find()) {
            Matcher ms = Pattern.compile("(<a(.*?)>.*?</a>)", Pattern.DOTALL).matcher(m.group());
            if (ms.find())
            {
                String re=ms.group();
//                System.out.println(re);
                int a=re.indexOf("href=\"");
                int b=re.indexOf("\"",a+10);
                String url=re.substring(a+6,b);
                System.out.println(url);
                int c=re.indexOf("title=");
                int d=re.indexOf("\">",c);
                String title=re.substring(c+7,d).trim();
               System.out.println("标题："+title);

            }
        }
    }
    public static void getFormatDate(){
        Date date = new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        System.out.println(dateString);
    }
    private static String get_Wz(String url){
        Matcher ms = Pattern.compile("(<div id=\"article_content\".*?/div>)", Pattern.DOTALL).matcher(httpRequest(url));
        if (ms.find())
        {
            return ms.group(1);
        }
        return null;
    }

    private static String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
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

}
