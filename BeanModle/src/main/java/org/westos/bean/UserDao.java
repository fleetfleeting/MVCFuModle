package org.westos.bean;

import java.sql.*;

public class UserDao {
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
            String sql="select * from hero_table where name=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,user.getName());
            //提交查询
            ResultSet resultSet = statement.executeQuery();
            b=resultSet.next();
            //System.out.println("是否调用了数据层:"+b);
            //关闭连接
            //System.out.println("是否有这个名字:"+b);
            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }
        return b;
    }

    public void Useradd(User user) {
        //连接数据库
        String driverName="com.mysql.jdbc.Driver";
        // jdbc:mysql://<数据库服务器Ip>:<数据库服务器端口>/<数据库名>
        String url="jdbc:mysql://localhost:3306/hero?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        try{
            Class.forName(driverName);
            //使用DriverManager获取连接
            Connection conn = DriverManager.getConnection(url, username, password);
            //执行insert语句
            String sql="insert into hero_table values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setNull(1, Types.NULL);//设置null值,数据库的序号会自动添加
            statement.setString(2,user.getName());
            statement.setString(3,user.getPassword());
            //提交添加
            statement.executeUpdate();
            //关闭连接
            conn.close();

        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库连接获取异常" + ex);
        }
    }
}
