package com.kaikeba.dao;

import com.kaikeba.beans.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 14:28
 */
public interface DeptMapper {

    @Select("")
    public List<Dept> deptFind(String param);
    public List<Dept> deptFind2(String param);
}

