package designPattern.behavior.mediation.common;

import designPattern.util.Logger;

import java.sql.*;

public class JDBCUtil {
    private static Logger logger = new Logger();

    public static final String URL = "jdbc:mysql://localhost:3306/house_search?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "Abcd123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获得连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3.操作数据库
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, title, price FROM house");

        while (resultSet.next()) {
            logger.info("id-{0}, title-{1}, price-{2}", resultSet.getInt("id"),
                    resultSet.getString("title"), resultSet.getInt("price"));
        }

        statement.close();
        connection.close();
    }
}
