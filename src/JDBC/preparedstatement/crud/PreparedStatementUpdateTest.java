package JDBC.preparedstatement.crud;

import JDBC.utils.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @Description 演示使用PreparedStatement替换Statement，解决SQL注入问题
 * @author shkstart  Email:shkstart@126.com
 * @version
 * @date 上午11:52:37
 *
 * 除了解决Statement的拼串、sql问题之外，PreparedStatement还有哪些好处呢？
 * 1.PreparedStatement操作Blob的数据，而Statement做不到。
 * 2.PreparedStatement可以实现更高效的批量操作。
 */

public class PreparedStatementUpdateTest {
    @Test
    public void testCommonUpdate(){
//		String sql = "delete from customers where id = ?";
//		update(sql,3);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql,"DD","2");
    }

    //通用的增删改操作
    public void update(String sql, Object ... args){//sql中占位符的个数与可变形参的长度相同！
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i + 1, args[i]);//小心参数声明错误！！ sql相关（包括占位符都是从1开始）
            }
            //4.执行
            /*
             * ps.execute():
             * 如果执行的是查询操作，有返回结果，则此方法返回true;
             * 如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             */
            //方式一：
            ps.execute();
            //方式二：
            //return ps.executeUpdate(); //此方法返回影响（修改了的）的行数，可用于判断修改是否成功（>0）
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    @Test
    public void updateTest() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            String sql = "update customers set name = ? where id = ?";

            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);

            //3.填充占位符
            ps.setObject(1, "贝多芬");
            ps.setObject(2, 18);

            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    @Test
    public void insertTest() {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1.读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBCConnectionConfig.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driver = pros.getProperty("driver");

            // 2.加载驱动
            Class.forName(driver);

            // 3.获取连接
            conn = DriverManager.getConnection(url, user, password);

            //4.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name, email, birth) values(?,?,?)";
            ps = conn.prepareStatement(sql);

            //5.填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1190-01-01");
            ps.setDate(3, new Date(date.getTime()));

            //6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源的关闭
            try {// 流的关闭还可能有异常，所以用try-catch包住
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {// 流的关闭还可能有异常，所以用try-catch包住
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}
