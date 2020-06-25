package JDBC.preparedstatement.crud;

import JDBC.preparedstatement.crud.bean.Customer;
import JDBC.utils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class PreparedStatementBlobTest {
    @Test
    public void blobInsertTest() throws Exception{  //插入blob数据
        Connection conn = JDBCUtils.getConnection();

        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1, "林俊杰");
        ps.setObject(2, "jj@mail.sdu.edu.cn");
        ps.setObject(3, "1990-08-09");

        FileInputStream fis = new FileInputStream(new File("F:\\javaProgramme\\JavaLearning\\src\\linjunjie.jpg"));
        ps.setObject(4, fis);

        ps.execute();

        JDBCUtils.closeResource(conn, ps);
    }

    @Test
    public void blobQueryTest() throws Exception{  //插入blob数据

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 22);

            resultSet = ps.executeQuery();
            if(resultSet.next()){
    //			方式一：
    //			int id = rs.getInt(1);
    //			String name = rs.getString(2);
    //			String email = rs.getString(3);
    //			Date birth = rs.getDate(4);

    //          方式二：
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");

                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                Blob photo = resultSet.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("linjunjie1.jpg");

                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }
}
