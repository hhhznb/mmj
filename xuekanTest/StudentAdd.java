package tit.bd.xuekanTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class StudentAdd {
    public static void main(String[] args) throws Exception {


        //1、注册驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、连接数据库
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xuekan?serverTimezone=UTC&useSSL=false","root","123456");
        System.out.println("连接成功 "+con);

        //3、创建PreparedStatem对象


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        int son = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入年级");
        String sex = sc.next();
        System.out.println("请输入性别");
        String grade = sc.next();
        System.out.println("请输入系部");
        String dept = sc.next();


        String sql = "insert into students values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        //4、给占位符赋值
        ps.setInt(1, son);
        ps.setString(2, name);
        ps.setInt(3,age);
        ps.setString(4,sex);
        ps.setString(5,grade);
        ps.setString(6,dept);





        //5、执行SQL语句
        int i = ps.executeUpdate();
        System.out.println("受影响行数 "+i);
        System.out.println();

        //6、处理结果
        if(i>0) {//有值
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        //7、关闭连接
        con.close();
        ps.close();
    }
}