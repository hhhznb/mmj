package tit.bd.xuekanTest;
import java.sql.*;
import java.util.Scanner;

public class PaperDelete {
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

        // 从用户输入中读取论文编号信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入论文编号：");
        int paperId = scanner.nextInt();

        // 执行 SQL 删除语句
        String sql = "DELETE FROM papers WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, paperId);

        // 执行 SQL，获取执行结果行数
        int affectedRows = statement.executeUpdate();

        // 处理执行结果
        if (affectedRows == 0) {
            System.out.println("未找到编号为 " + paperId + " 的论文记录，请检查论文编号是否正确！");
        } else {
            System.out.println("成功删除编号为 " + paperId + " 的论文记录！");
        }

        // 关闭数据库连接
        statement.close();
        connection.close();
    }
}
