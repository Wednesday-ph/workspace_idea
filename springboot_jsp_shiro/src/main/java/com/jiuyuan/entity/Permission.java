package com.jiuyuan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author shkstart
 * @create 2021-07-30 14:18
 */
@Data
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private String id;
    private String name;
    private String url;

}
