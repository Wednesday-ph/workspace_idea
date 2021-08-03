package com.jiuyuan.shiro.realms;

import com.jiuyuan.entity.Permission;
import com.jiuyuan.entity.User;
import com.jiuyuan.service.UserService;
import com.jiuyuan.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-22 15:04
 */
public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

        User user = userService.findRolesByUsername(primaryPrincipal);

        if(!CollectionUtils.isEmpty(user.getRoles())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role->{
                simpleAuthorizationInfo.addRole(role.getName());
                System.out.println("+++++++++roleName = "+role.getName());
                List<Permission> perms = userService.findPermsByRoleid(role.getId());
                if(!CollectionUtils.isEmpty(perms)){
                    perms.forEach(perm->{
                        System.out.println("++++++++++++permName = "+perm.getName());
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }else
            System.out.println("--------------没有去角色");


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();

        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

        User user = userService.findByUsername(principal);
        System.out.println("user: "+user);

        if(!ObjectUtils.isEmpty(user)){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            return simpleAuthenticationInfo;

        }

        return null;
    }
}
