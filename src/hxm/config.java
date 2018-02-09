package hxm;

public class config {
    //第一步创建一个数据库，或者用已经纯在的数据库，本程序不支持创建数据
    //后台在xxxxx.com/admin
    //后台账号，密码为：admin root
    //配置
    //数据库名字
    public static String dbname="hxmtop";
    //数据库用户名
    public static String dbuser="hxmtop";
    //数据库的用户密码
    public static String dbpwd="M135799";
    //163邮箱账号
    public static String mail_num="15228311770@163.com";
    //邮箱独立服务器密码
    public static String mail_pwd="135799M";
    //接收者邮箱
    public static String mail_my="1417262058@qq.com";
    //爬虫时间控制
    public static long period = 24*60*60*1000;
    //不可修改
    //爬虫控制
    public static boolean task_status=false;
    //数据库控制
    public static String sql1="SET FOREIGN_KEY_CHECKS=0;";
    public static String sql2="DROP TABLE IF EXISTS `article`";
    public static String sql3=
            "CREATE TABLE `article` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `title` text NOT NULL,\n" +
            "  `content` text NOT NULL,\n" +
            "  `time` text NOT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;\n";
    public static String sql4="DROP TABLE IF EXISTS `pa`";
    public static String sql5=
            "CREATE TABLE `pa` (\n" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` text NOT NULL,\n" +
                    "  `content` text NOT NULL,\n" +
                    "  `time` text NOT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=MyISAM AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;\n";
}
