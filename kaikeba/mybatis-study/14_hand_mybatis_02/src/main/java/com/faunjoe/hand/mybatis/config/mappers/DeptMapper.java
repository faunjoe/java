package com.faunjoe.hand.mybatis.config.mappers;

import com.faunjoe.hand.mybatis.beans.Dept;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:17
 */
public interface DeptMapper {

    Dept selectByPrimaryKey(Integer userId);
}
