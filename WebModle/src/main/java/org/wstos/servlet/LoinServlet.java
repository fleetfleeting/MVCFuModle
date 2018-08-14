package org.wstos.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.westos.bean.User;
import org.westos.service.UserloginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoinServlet")
public class LoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("调用了servlet!");

        try {
            //设置编码格式
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user=new User();
            BeanUtils.populate(user,map);
            //System.out.println("servlet的用户名是:"+user.getName());
            boolean b = new UserloginService().userLogin(user);
            if(b){
                //输出登陆成功
                response.getWriter().write("恭喜,登陆成功!");
            }else{
                //输出登陆失败,并重新加载登陆页面
                request.setAttribute("msg","用户名或密码不匹配");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
