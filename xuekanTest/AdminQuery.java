package tit.bd.xuekanTest;
import java.sql.*;
import java.util.Scanner;

public class AdminQuery {
    public static void main(String[] args) throws Exception {
        // 注册 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false",
                "root",
                "123456"
        );
        System.out.println("连接成功");

        // 接受管理员用户名
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的管理员用户名：");
        String username = scanner.nextLine();

        // 执行 SQL 查询语句
        String sql = "SELECT * FROM admin WHERE username=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();

        // 处理查询结果
        if (resultSet.next()) {
            System.out.println("查询成功！");
            System.out.println("管理员 ID： " + resultSet.getInt("id"));
            System.out.println("管理员用户名： " + resultSet.getString("username"));
            System.out.println("管理员密码： " + resultSet.getString("password"));
            System.out.println("管理员真实姓名： " + resultSet.getString("realname"));
            System.out.println("管理员性别： " + resultSet.getString("gender"));
            System.out.println("管理员角色： " + resultSet.getString("role"));
        } else {
            System.out.println("没有找到用户名为 " + username + " 的管理员记录，查询失败！");
        }

        // 关闭数据库连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
