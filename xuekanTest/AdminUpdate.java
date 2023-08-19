package tit.bd.xuekanTest;

import java.sql.*;
import java.util.Scanner;

public class AdminUpdate {
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

        // 接受管理员信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要修改的管理员 ID：");
        int id = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        System.out.print("请输入新的管理员用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入新的管理员密码：");
        String password = scanner.nextLine();
        System.out.print("请输入新的管理员真实姓名：");
        String realname = scanner.nextLine();
        System.out.print("请输入新的管理员性别：");
        String gender = scanner.nextLine();
        System.out.print("请输入新的管理员角色：");
        String role = scanner.nextLine();

        // 执行 SQL 更新语句
        String sql = "UPDATE admin SET username=?, password=?, realname=?, gender=?, role=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, realname);
        statement.setString(4, gender);
        statement.setString(5, role);
        statement.setInt(6, id);

        // 执行 SQL 更新语句
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows > 0) {
            System.out.println("成功更新 " + affectedRows + " 条管理员记录！");
        } else {
            System.out.println("没有找到管理员 ID 为 " + id + " 的记录，更新失败！");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}