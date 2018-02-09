package hxm.mail;

import hxm.config;
public class Mail {
    public boolean send (String res){
        try {
            MailSenderInfo mailInfo = new MailSenderInfo();
            //定义邮箱的SMTP服务器！
            mailInfo.setMailServerHost("smtp.163.com");
            mailInfo.setMailServerPort("25");
            mailInfo.setValidate(true);
            mailInfo.setUserName(config.mail_num); // 邮箱帐号
            mailInfo.setPassword(config.mail_pwd);// 邮箱服务独立密码
            mailInfo.setFromAddress(config.mail_num); // 邮箱帐号
            mailInfo.setToAddress(config.mail_my); //你邮箱接受者
            mailInfo.setSubject("黑小马*博客信息"); //邮箱发送标题
            mailInfo.setContent(res); //邮箱发送内容
            SimpleMailSender sms = new SimpleMailSender();
            sms.sendTextMail(mailInfo);
            return true;
        }catch (Exception e){

            return false;

        }

    }


}