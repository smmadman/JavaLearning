package Reflection.SimpleUse;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2); // null 此时为引导类加载器，虽然有但是无法获取

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3); // null 此时为引导类加载器，虽然有但是无法获取
    }

    @Test
    //不使用ClassLoader读取配置文件
    public void test2() throws Exception{
        Properties pros = new Properties();
        //此时默认的相对目录，在module下
        FileInputStream fis = new FileInputStream(new File("ClassLoaderTest.properties"));
        pros.load(fis);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user = " + user + ", password = " + password);
    }

    @Test
    //使用ClassLoader读取配置文件
    public void test3() throws Exception{
        Properties pros = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //此时默认的相对路径，在src下,区别于使用流读取配置文件
        InputStream is = classLoader.getResourceAsStream("ClassLoaderTest2.properties");

        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }
}
