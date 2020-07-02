package Reflection.SimpleUse;

/*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
     */

import org.junit.Test;

public class ClassTest {
    //获取Class的实例的方式（前三种方式需要掌握）

    @Test
    public void test() throws Exception{
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("Reflection.SimpleUse.Person");//此方法使用多
        Class clazz4 = Class.forName("java.lang.String");

        System.out.println(clazz3);
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);//都为true证明是同一个运行时类
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz5 = classLoader.loadClass("Reflection.SimpleUse.Person");
        System.out.println(clazz5);
        System.out.println(clazz1 == clazz5);

    }
}
