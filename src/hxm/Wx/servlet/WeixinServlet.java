package hxm.Wx.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.DocumentException;
import hxm.Wx.po.TextMessage;
import hxm.Wx.util.CheckUtil;
import hxm.Wx.util.MessageUtil;

public class WeixinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
		//微信服务器GET请求携带的四个参数
		//signature：微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
		String signature = req.getParameter("signature");//注意括号里加双引号！！！
		//timestamp：时间戳
		String timestamp = req.getParameter("timestamp");
		//nonce：随机数
		String nonce = req.getParameter("nonce");
		//echostr：随机字符串
		String echostr = req.getParameter("echostr");
		//调用CheckUtil类的checkSignature方法校验，真则返回echostr值
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.println(echostr);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter out = resp.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(req);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			System.out.println("------------------++++++++++"+msgType);
			String message = null;
			if ("text".equals(msgType)) {                // 对文本消息进行处理
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);         // 发送和回复是反向的
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());

				if(content.equals("开始游戏")){
				text.setContent("游戏瘫痪，给红包自动修复！给了红包发，1，没给发，2");

				}else if(content.equals("1")){
					text.setContent("嘻嘻！我看你们接吻，3，吻了，4没有吻");
				}else if(content.equals("3")){
					text.setContent("哈哈！勇哥你亲的的声音不够大，罚红包一个，并重新亲嫂子，记住声音一定要大，要大！\n如果以上步骤已经做完，请发，5");
				}else if(content.equals("5")){
					text.setContent("嘿嘿，来到关键时刻！大声说出你们的爱，勇哥先说哈！\n完成后发，6");
				}
				else if(content.equals("6")){
					text.setContent("嫂子该你说了哟！完成后发，7");
				}
				else if(content.equals("7")){
					text.setContent("神秘的事情开始了哦！ 继续请回复，8");
				}
				else if(content.equals("8")){
					text.setContent("想听听对方真心话吗？发红包哈！ 男方：9，女方：10");
				}
				else if(content.equals("9")){
					//女方语音消息
					text.setContent("没有录制请及时表演");
				}else if(content.equals("10")){
					//男方语音消息
					text.setContent("没有录制请及时表演");
				}
				else if(content.equals("4")){
					text.setContent("游戏结束");
				}
				else if(content.equals("2")){
					text.setContent("游戏结束");
				}else {
					text.setContent("小马未开发其他选项！");
				}
				message = MessageUtil.textMessageToXML(text);
				}
			else  if ("event".equals(msgType)){
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);         // 发送和回复是反向的
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("欢迎来到，勇哥和嫂子的专属领地！");
				message = MessageUtil.textMessageToXML(text);
			}
			out.print(message);                            // 将回应发送给微信服务器
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
