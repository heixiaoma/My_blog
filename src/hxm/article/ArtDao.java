package hxm.article;

import hxm.sql.DBhelper;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ArtDao extends DBhelper {
    public List<articles> get_page_one(){
        List<articles> list=new ArrayList<articles>();
        String sql="SELECT * FROM article order by id desc limit 5";
        ResultSet rs=this.execteQuery(sql);
        try {
            while (rs.next()){
                list.add(new articles(rs.getInt(1),new String(rs.getString(2).getBytes("utf-8"),"utf-8"),rs.getString(3),rs.getString(4)));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return list;
    }
    public List<articles> get_All() {
        List<articles> list=new ArrayList<articles>();
        String sql="SELECT * FROM article order by id desc";
        ResultSet rs=this.execteQuery(sql);
        try {
            while (rs.next()){
                list.add(new articles(rs.getInt(1),new String(rs.getString(2).getBytes("utf-8"),"utf-8"),rs.getString(3),rs.getString(4)));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return list;
    }
    public articles get_one(String id) {
        String sql="SELECT * FROM article where id="+id;
        ResultSet rs=this.execteQuery(sql);
        System.out.println(sql);
        try {

            while (rs.next()){
                articles ar= new articles(rs.getInt(1),new String(rs.getString(2).getBytes("utf-8"),"utf-8"),rs.getString(3),rs.getString(4));
                return ar;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return null;
    }
    public int insert(String title,String content){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        int flage=this.executeUpdate("INSERT INTO article VALUES(NULL,'"+title+"','"+content+"','"+hehe+"');");
        return flage;
    }
    public int delete(String id){
        int flage=this.executeUpdate("DELETE FROM article WHERE id="+id);
        return flage;
    }
    public List<articles> get_page_next(int page) {
        List<articles> list=new ArrayList<articles>();
        String sql="SELECT * FROM article order by id desc limit "+(page*5)+",5";
        System.out.println(sql);
        ResultSet rs=this.execteQuery(sql);
        try {
            while (rs.next()){
                list.add(new articles(rs.getInt(1),new String(rs.getString(2).getBytes("utf-8"),"utf-8"),rs.getString(3),rs.getString(4)));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return list;
    }
    public int get_count() {
        List<articles> list=new ArrayList<articles>();
        String sql="SELECT count(*) FROM article order by id desc";
        ResultSet rs=this.execteQuery(sql);
        try {
            while (rs.next()){
               return  rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return 0;
    }
    public int install(String sql){
        int flage=this.executeUpdate(sql);
        return flage;
    }
}
