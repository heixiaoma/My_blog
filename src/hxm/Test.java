package hxm;

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
        //getFormatDate();
       // System.out.println(get_Wz("http://blog.csdn.net/qq_34137397/article/details/72837353"));
        get_Title();
    }

    private static void get_Title(){
        String res = httpRequest("https://www.csdn.net/nav/lang");
        Pattern p = Pattern.compile("<h2(.*?)</h2>");
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
                int c=re.indexOf(">");
                int d=re.indexOf("<",c);
                String title=re.substring(c+1,d).trim();
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
            httpUrlConn.setRequestProperty("Cookie","uuid_tt_dd=3260494214781029992_20171118; UM_distinctid=1608bcd613674c-0532a9662601ad-4d015463-1fa400-1608bcd61374af; kd_user_id=dae78c0f-46cb-4682-b715-98d039d43f43; gr_user_id=02742594-cd5c-41ab-8bec-e4c1e746adbe; uaid=31f829d7567059c56ab342334ef29e6e; __message_sys_msg_id=0; __message_gu_msg_id=0; __message_cnel_msg_id=0; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; TY_SESSION_ID=c99321c6-6ef9-48ca-bbf8-04904980ee45; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1518007241,1518102503,1518155060,1518168713; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1518169421; ADHOC_MEMBERSHIP_CLIENT_ID1.0=5e4bc303-0736-44fa-420d-e9884314279d; dc_tos=p3vn0t; dc_session_id=10_1518106932801.655471");
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
