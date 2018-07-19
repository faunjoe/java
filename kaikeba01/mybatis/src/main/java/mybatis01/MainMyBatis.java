package mybatis01;


import mybatis01.com.kaikeba.beans.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/12 00:06
 */
public class MainMyBatis {

    public static void main(String[] args) throws Exception {

        Dept dept = new Dept();
        dept.setDname("MyBatis项目");
        dept.setLoc("北京");

        InputStream is = Resources.getResourceAsStream("mybatis01/MyBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        session.insert("insertDept",dept);
        session.commit();
        session.close();
    }
}
