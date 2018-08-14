package org.westos.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userlogin {

    public boolean findUser(User user) {
        //连接数据库
        String driverName="com.mysql.jdbc.Driver";
        // jdbc:mysql://<数据库服务器Ip>:<数据库服务器端口>/<数据库名>
        String url="jdbc:mysql://localhost:3306/hero?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        boolean b=false;
        try{
            Class.forName(driverName);
            //使用DriverManager获取连接
            Connection conn = DriverManager.getConnection(url, username, password);
            //执行select语句
            String sql="SELECT NAME , PASSWORD FROM hero_table WHERE NAME=? AND PASSWORD=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            //提交查询
            ResultSet resultSet = statement.executeQuery();
            b=resultSet.next();
            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }
        //System.out.println("用户名是:"+user.getName());
       //System.out.println("密码是:"+user.getPassword());
        //System.out.println("查询密码:"+b);
        return b;
    }
}
