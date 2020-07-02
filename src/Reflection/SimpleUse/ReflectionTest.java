package Reflection.SimpleUse;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    //反射之前，对于Person的操作
    @Test
    public void test1() {

        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2.通过对象，调用其内部的属性、方法
        p1.name = "Tommy";
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }

    //反射之后，对于Person的操作
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;

        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Amy", 12);
        Person p = (Person) obj;
        System.out.println(p);

        //2.通过反射，调用对象指定的属性、方法

        //调用属性
        Field name = clazz.getDeclaredField("name");
        name.set(p, "NameChanged");
        System.out.println(p);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("**************************************");

        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性

        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(int.class);
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance(20);
        System.out.println("调用private age构造器：" + p1);
        name.set(p1, "P1");
        System.out.println("更改public 属性 name之后" + p1);

        //调用私有的属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(p1, 25);
        System.out.println("更改private 属性 age之后" + p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");
        System.out.println("调用private 方法 showNation之后，拿到的返回值nation为：" + nation);
    }
}
