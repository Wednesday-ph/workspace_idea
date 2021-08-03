package com.jiuyuan.Controller;

import com.jiuyuan.entity.User;
import com.jiuyuan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2021-07-23 13:21
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

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

    @RequestMapping("register")
    public String register(User user){
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }

    @RequestMapping("save")
    public String save(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.hasRole("user"))
            System.out.println("保存订单");
        else
            System.out.println("无权访问");

        if(subject.isPermitted("user.create.01"))
            System.out.println("user.crete,01");
        else
            System.out.println("?.?.?");

        return "redirect:/index.jsp";
    }

    @RequiresRoles(value = {"admin","user"})
    @RequiresPermissions("user.create.01")
    @RequestMapping("update")
    public String update(){
        System.out.println("update");
        return "redirect:/index.jsp";
    }

    @RequiresRoles("user")
    @RequiresPermissions("user.create.01")
    @RequestMapping("delete")
    public String delete(){
        System.out.println("delete");
        return "redirect:/index.jsp";
    }
}
