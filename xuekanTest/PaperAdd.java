package tit.bd.xuekanTest;

import java.sql.*;
import java.util.Scanner;

public class PaperAdd {
    public static void main(String[] args) throws Exception {
        // 注册 JDBC 驱动 (可以省略此步骤)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 建立数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false",
                "root",
                "123456"
        );
        System.out.println("连接成功");

        // 读取用户输入的论文信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入论文题目：");
        String title = scanner.nextLine();
        System.out.println("请输入作者：");
        String author = scanner.nextLine();
        System.out.println("请输入导师：");
        String supervisor = scanner.nextLine();
        System.out.println("请输入关键词：");
        String keywords = scanner.nextLine();
        System.out.println("请输入摘要：");
        String summary = scanner.nextLine();
        System.out.println("请输入正文：");
        String content = scanner.nextLine();
        System.out.println("请输入参考文献：");
        String reference = scanner.nextLine();

        // 编写 SQL 语句
        String sql = "INSERT INTO papers (title, author, supervisor, keywords, abstract, content, reference) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 填充占位符
        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, supervisor);
        statement.setString(4, keywords);
        statement.setString(5, summary);
        statement.setString(6, content);
        statement.setString(7, reference);

        // 执行 SQL 语句
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows == 1) {
            System.out.println("添加论文成功！");
        } else {
            System.out.println("添加论文失败。");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}