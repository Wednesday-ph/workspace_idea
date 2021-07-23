package com.jiuyuan.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2021-07-23 13:21
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String login(String username, String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username,password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名出错");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码出错");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


        return "redirect:/login.jsp";
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }
}
