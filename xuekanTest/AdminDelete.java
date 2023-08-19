package tit.bd.xuekanTest;
import java.sql.*;
import java.util.Scanner;

public class AdminDelete {
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

        // 接受管理员 ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要删除的管理员 ID：");
        int id = scanner.nextInt();

        // 执行 SQL 删除语句
        String sql = "DELETE FROM admin WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        // 执行 SQL 删除语句
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows > 0) {
            System.out.println("成功删除 " + affectedRows + " 条管理员记录！");
        } else {
            System.out.println("没有找到管理员 ID 为 " + id + " 的记录，删除失败！");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}