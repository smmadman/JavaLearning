package JDBC;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionLearning {
    @Test
    //方式1
    public void Connection1() throws SQLException {
        // 获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();

        // url:http://localhost:8080/gmall/keyboard.jpg
        // jdbc:mysql:协议
        // localhost:ip地址
        // 3306：默认mysql的端口号
        // test:test数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "y32163214");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }

    @Test
    //方式2：对于方式一的改进，改进点：
    //  在方式1中，使用了外部包com.mysql.jdbc.Driver，当换其他数据库时，还需重新编写代码
    //  所以方式2利用反射解决这个问题
    //  不出现第三方api使得有更好的移植性
    public void connection2() throws Exception{
        //利用反射来代替方法1中driver的实例化
        //Driver driver = new com.mysql.jdbc.Driver();
        //之后其他与方式1不变
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "y32163214");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }

    // 方式三：使用DriverManager替换Driver
    @Test
    public void connection3() throws Exception{
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "y32163214";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void connection4() throws Exception {
        // 1.提供三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "y32163214";

        // 2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //相较于方式三，可以省略如下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(driver);
        //为什么可以省略上述操作呢？
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    //方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
     * 此种方式的好处？
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void connection5() throws Exception{

        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionLearning.class.getClassLoader().getResourceAsStream("JDBCConnectionConfig.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");

        //2.加载驱动
        Class.forName(driver);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
