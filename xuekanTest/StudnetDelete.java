package tit.bd.xuekanTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudnetDelete {
    public static void main(String[] args) throws Exception {
        //1、注册驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、连接数据库
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false","root","123456");
        System.out.println("连接成功 "+con);

        //3、创建 PrepadStatemen对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号 ");
        int son = sc.nextInt();

        String sql = "delete from students where sno = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        //4、给占位符赋值
        ps.setInt(1, son);

        //5、执行SQL语句
        int i = ps.executeUpdate();

        //6、处理结果
        if(i>0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        //7、关闭连接
        con.close();
        ps.close();
    }
}



