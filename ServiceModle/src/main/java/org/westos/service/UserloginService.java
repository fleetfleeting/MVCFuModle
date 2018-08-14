package org.westos.service;

import org.westos.bean.User;
import org.westos.bean.Userlogin;

public class UserloginService {
    public boolean userLogin(User user) {
        //业务层
        //调用数据层来判断
        //System.out.println("调用了service!");
        boolean  b=new Userlogin().findUser(user);
        //System.out.println("是否调用了业务层:"+b);
        return b;
    }
}
