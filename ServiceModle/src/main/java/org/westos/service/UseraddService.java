package org.westos.service;

import org.westos.bean.User;
import org.westos.bean.UserDao;

public class UseraddService {

    //业务层
    //组装业务逻辑
    //先要判断用户是否存在,如果不存在的话,再添加进去
    public boolean useradd(User user) {
        //调用数据层
        UserDao dao = new UserDao();
        boolean b= dao.findUser(user);
        if(!b){
            dao.Useradd(user);
        }
        return b;
    }
}
