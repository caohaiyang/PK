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
            Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or��
            // new com.mysql.jdbc.Driver();
            System.out.println("�ɹ�����MySQL��������");
            // һ��Connection����һ�����ݿ�����
            conn = DriverManager.getConnection(url);
            // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
            java.sql.Statement stmt = conn.createStatement();
            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);// executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
            if (result != -1) {
                System.out.println("�������ݱ�ɹ�");
                sql = "insert into student(NO,name) values('2012001','��ΰ��')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','��С��')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
                System.out.println("ѧ��\t����");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// ��������ص���int���Ϳ�����getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL��������");
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
