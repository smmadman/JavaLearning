package JDBC.preparedstatement.crud;

import JDBC.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EncodingTest {
    @Test
    public void EncodingTest1() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into goods(name) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1, "林俊杰");
        ps.execute();

        JDBCUtils.closeResource(conn, ps);
    }
}
