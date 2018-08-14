package org.wstos.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.bean.User;
import org.westos.service.UseraddService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class UseraddServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //System.out.println("调用了Servlet!");
        try {
            //设置编码格式
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user=new User();
            BeanUtils.populate(user,map);
            //System.out.println("用户名是:"+user.getName());
            boolean b=new UseraddService().useradd(user);
            if(!b){
                //成功就输出注册成功
                response.getWriter().write("success+注册成功");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                //失败就输出注册失败
                request.setAttribute("msg","注册失败,用户名已存在");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
