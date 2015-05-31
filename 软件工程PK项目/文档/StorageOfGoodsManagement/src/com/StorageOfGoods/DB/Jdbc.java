package com.StorageOfGoods.DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.StorageOfGoods.Function.Box;
import com.StorageOfGoods.Function.Customer;
import com.StorageOfGoods.Function.DataOperating;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Jdbc {
	public static void main(String[] args) {
		//Jdbc ms = new Jdbc();
		//ms.connectMysql();
		//Box box = new Box(8,3,"A");
		//Customer cust = new Customer(null,"18463100723",0);
		DataOperating daop = new DataOperating();
		Vector<Customer> vt = new Vector<Customer>();
		//vt = daop.getCustomerByBoxNum(2);
		//daop.addBox(box);
		//daop.deleteCustomer(cust);
		//System.out.println(daop.getPassWordByUserName("admi"));
	}
	public void connectMysql(){
		
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();
            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            java.sql.Statement stmt = conn.createStatement();
            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                System.out.println("创建数据表成功");
                sql = "insert into student(NO,name) values('2012001','陶伟基')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','周小俊')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
}
