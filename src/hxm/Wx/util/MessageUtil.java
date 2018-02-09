package hxm.Wx.util;

import hxm.Wx.po.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {

		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();            // 使用dom4j解析xml
		InputStream ins = request.getInputStream(); // 从request中获取输入流
		Document doc = reader.read(ins);

		Element root = doc.getRootElement();         // 获取根元素
		List<Element> list = root.elements();        // 获取所有节点

		for (Element e : list) {
			map.put(e.getName(), e.getText());
			System.out.println(e.getName() + "--->" + e.getText());
		}
		ins.close();
		return map;
	}

	/**
	 * 将文本消息对象转换成XML
	 */
	public static String textMessageToXML(TextMessage textMessage){
		String xml="<xml>\n" +
				"<ToUserName><![CDATA["+textMessage.getToUserName()+"]]></ToUserName>\n" +
				"<FromUserName><![CDATA["+textMessage.getFromUserName()+"]]></FromUserName>\n" +
				"<CreateTime>"+textMessage.getCreateTime()+"</CreateTime>\n" +
				"<MsgType><![CDATA["+textMessage.getMsgType()+"]]></MsgType>\n" +
				"<Content><![CDATA["+textMessage.getContent()+"]]></Content>\n" +
				"</xml>";
		return xml;
	}
}