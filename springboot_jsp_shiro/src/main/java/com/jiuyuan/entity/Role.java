package com.jiuyuan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-07-30 14:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role {
    private String id;
    private String name;

    private List<Permission> perms;
}
