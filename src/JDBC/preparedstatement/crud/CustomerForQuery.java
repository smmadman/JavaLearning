package JDBC.preparedstatement.crud;

import JDBC.preparedstatement.crud.bean.Customer;
import JDBC.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/*
 * 对于customers表的低级-高级操作
 * 针对于表的字段名与类的属性名不相同的情况：
 * 1. 必须声明sql时，使用类的属性名来命名字段的别名
 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
 *    获取列的别名。
 *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
 */

public class CustomerForQuery {

    @Test
    public void queryForCustomersTest(){
        String url = "select name, id from customers where id = ?";

        System.out.println(queryForCustomers(url, 1));
    }

    public Customer queryForCustomers(String url, Object ... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(url);

            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();
            //获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();

            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()) {
                Customer cust = new Customer();
                //处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);

                    // String columnName = metaData.getColumnName(i + 1);
                    // getColumnName获取的是列名，更改别名并不会改变列名，所以为了通用性，使用getColumnLabel
                    // getColumnName不推荐使用
                    String columnLabel = metaData.getColumnLabel(i + 1);//获取每个列的列名（别名）

                    //给cust对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
        return null;
    }

    @Test
    public void queryTest() throws Exception{

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, email, birth from customers where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);

            //执行,并返回结果集
            resultSet = ps.executeQuery();

            if(resultSet.next()){//next():判断结果集的下一条是否有数据，如果有数据返回true,并指针下移；如果返回false,指针不会下移。

                //获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //方式一：
    //			System.out.println("id = " + id + ",name = " + name + ",email = " + email + ",birth = " + birth);

                //方式二：
    //			Object[] data = new Object[]{id,name,email,birth};
                //方式三：将数据封装为一个对象（推荐）
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

    }

}

