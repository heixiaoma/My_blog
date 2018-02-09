package hxm.sql;

import hxm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBhelper {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String url = "jdbc:mysql://127.0.0.1:3306/"+ config.dbname+"?useUnicode=true&characterEncoding=utf-8";
    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //注意点，sqlite需要指定路径
            this.conn = DriverManager.getConnection(url,config.dbuser,config.dbpwd);
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            if (rs!=null)
                rs.close();
            if (ps!=null)
                ps.close();
            if (conn!=null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //更新
    public int executeUpdate(String sql,Object...objects){
       try {
           this.getConnection();
           ps=conn.prepareStatement(sql);
           if (conn!=null){
               for (int i=0;i<objects.length;i++){
                   ps.setObject(i+1,objects[i]);
               }
               return ps.executeUpdate();
           }

       }catch (Exception e){
            e.printStackTrace();
       }finally {
           this.close();
       }
       return  -1;

    }
    //查询
    public ResultSet execteQuery(String sql,Object...objects){
        try {
            this.getConnection();
             ps=conn.prepareStatement(sql);
            if (conn!=null){
                for (int i=0;i<objects.length;i++){
                    ps.setObject(i+1,objects[i]);
                }
              return rs=ps.executeQuery();
            }
        }catch (Exception e){
            System.out.println("错误：-----"+e.getMessage());
        }
        return null;
    }
}
