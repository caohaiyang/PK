package com.StorageOfGoods.Function;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

public class DataOperating {
	//���ӼĴ��
	public void addBox(Box box){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            //java.sql.Statement stmt = conn.createStatement();
            java.sql.PreparedStatement ps = null;
            sql = "insert into box(BOX_NUM,TYPE,PHONE_NUM,STATE,START_TIME) values(?,?,?,?,?)";
            try{
            	ps = conn.prepareStatement(sql);
            	ps.setInt(1,box.getBoxNum());
            	ps.setString(2,box.getType());
            	ps.setString(3,box.getPhoneNum());
            	ps.setInt(4,0);
            	ps.setDate(5,null);
            	ps.executeUpdate();
            	ps.close();
            }catch (SQLException e) {
            	e.printStackTrace();
            } finally {
            	conn.close();
            }
        } catch (SQLException e) {
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
	//ɾ���Ĵ��
	public void deleteBox(Box box){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
           // java.sql.Statement stmt = conn.createStatement();
            java.sql.PreparedStatement ps = null;
            sql = "delete from BOX where BOX_NUM = '" + box.getBoxNum() + "'";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ps.executeUpdate();
            	ps.close();
            	conn.close();
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
	//���ӹ˿�
	public void addCustomer(Customer cust){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            //java.sql.Statement stmt = conn.createStatement();
            java.sql.PreparedStatement ps = null;
            sql = "insert into customer(PHONE_NUM,CUST_NAME,REMARK,DEPOSIT,CONSUM) values(?,?,?,?,?)";
            try{
            	ps = conn.prepareStatement(sql);
            	ps.setString(1,cust.getPhoneNum());
            	ps.setString(2,cust.getName());
            	ps.setString(3,cust.getRemark());
            	ps.setDouble(4,cust.getDeposit());
            	ps.setDouble(5,cust.getConsumption());
            	ps.executeUpdate();
            	ps.close();
            }catch (SQLException e) {
            	e.printStackTrace();
            } finally {
            	conn.close();
            }
        } catch (SQLException e) {
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
	//ɾ���˿�
	public void deleteCustomer(Customer cust){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = null;
            sql = "delete from Customer where PHONE_NUM = '" + cust.getPhoneNum() + "'";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ps.executeUpdate();
            	ps.close();
            	conn.close();
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
	//ͨ���û�����������
	public String getPassWordByUserName(String userName){
		String passWord;
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = null;
            sql = "select PASSWORD from account where NAME = ?";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ps.setString(1, userName);
            	ResultSet rs = ps.executeQuery();
            	if(rs.next()){
            		passWord = rs.getString(1);
            		return passWord;
            		
            	}
            	ps.close();
            	conn.close();
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
        return null;
	}
	//���ؼĴ������
	public Vector<Type> getCabinetType(){
		Vector<Type> vt = new Vector<Type>();
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = null;
            sql = "select * from type";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ResultSet rs = ps.executeQuery();
            	Type type;
            	while(rs.next()){
            		type = new Type(rs.getString(1),rs.getDouble(2));
            		vt.add(type);
            	}
            	ps.close();
            	conn.close();
            	return vt;
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
		return null;
	}
	//ͨ�����ͷ��ؼĴ����
	public Vector<Integer> getBoxNumByType(String type){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = null;
            sql = "select BOX_NUM from box where TYPE = ?";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ps.setString(1, type);
            	ResultSet rs = ps.executeQuery();
            	Vector<Integer> vt = new Vector<Integer>();
            	while(rs.next()){
            		vt.add(rs.getInt(1));
            	}
            	ps.close();
            	conn.close();
            	return vt;
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
		return null;
	}
	//ͨ���Ĵ��״̬��üĴ����
	public Vector<Integer> getBoxNumByState(int state){
		java.sql.Connection conn = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            java.sql.PreparedStatement ps = null;
            sql = "select BOX_NUM from box where STATE = ?";
            try{
            	ps = (PreparedStatement) conn.prepareStatement(sql);
            	ps.setInt(1, state);
            	ResultSet rs = ps.executeQuery();
            	Vector<Integer> vt = new Vector<Integer>();
            	while(rs.next()){
            		vt.add(rs.getInt(1));
            	}
            	ps.close();
            	conn.close();
            	return vt;
            }catch(SQLException e){
            	e.printStackTrace();
            }
            
        } catch (SQLException e) {
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
		return null;
	}
	//ͨ���Ĵ���Ż�üĴ��״̬
		public int getStateByBoxNum(int num){
			java.sql.Connection conn = null;
	        String sql;
	        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
	                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            java.sql.PreparedStatement ps = null;
	            sql = "select STATE from box where BOX_NUM = ?";
	            try{
	            	ps = (PreparedStatement) conn.prepareStatement(sql);
	            	ps.setInt(1, num);
	            	ResultSet rs = ps.executeQuery();
	            	if(rs.next()){
	            		return rs.getInt(1);
	            	}
	            	ps.close();
	            	conn.close();
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
	            
	        } catch (SQLException e) {
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
			return 1;

		}
	//ͨ���Ĵ���Ż�ù˿���Ϣ
		public Customer getCustomerByBoxNum(int num){
			java.sql.Connection conn = null;
	        String sql;
	        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
	                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            java.sql.PreparedStatement ps = null;
	            sql = "select PHONE_NUM from box where BOX_NUM = ?";
	            try{
	            	ps = (PreparedStatement) conn.prepareStatement(sql);
	            	ps.setInt(1, num);
	            	ResultSet rs = ps.executeQuery();
	            	Vector<Customer> vt = new Vector<Customer>();
	            	Customer customer = null;
	            	while(rs.next()){
	            		sql = "select * from customer where PHONE_NUM = ?";
	            		ps = (PreparedStatement) conn.prepareStatement(sql);
	            		ps.setString(1, rs.getString(1));
	            		ResultSet rst = ps.executeQuery();
	            		while(rst.next()){
	            		customer = new Customer(rst.getString(2),rst.getString(1),rst.getDouble(4),rst.getDouble(5),rst.getString(3));
	            		vt.add(customer);
	            		}
	            	}
	            	ps.close();
	            	conn.close();
	            	//return vt;
	            	return customer;
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
	            
	        } catch (SQLException e) {
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
			return null;
		}
		//ͨ���Ĵ��״̬��ÿյļĴ����
		public Vector<Integer> getEmptyBoxNumByType(String type){
			Vector<Integer> vt = new Vector<Integer>();
			Vector<Integer> vtt = new Vector<Integer>();
			vt = getBoxNumByType(type);
			for(int i = 0; i < vt.size(); i++){
			    if(getStateByBoxNum(vt.get(i)) == 0){
			    	vtt.add(vt.get(i));
			    }
			}
			return vtt;
		}
		//ͨ���Ĵ���Ż����ϵ�绰
        public String getPhoneNumByBoxNum(int num){
			java.sql.Connection conn = null;
	        String sql;
	        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
	                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            java.sql.PreparedStatement ps = null;
	            sql = "select PHONE_NUM from box where BOX_NUM = ?";
	            try{
	            	ps = (PreparedStatement) conn.prepareStatement(sql);
	            	ps.setInt(1, num);
	            	ResultSet rs = ps.executeQuery();
	            	if(rs.next()){
	            		return rs.getString(1);
	            	}
	            	ps.close();
	            	conn.close();
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
	            
	        } catch (SQLException e) {
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
			return null;
		}
		//ͨ����ϵ�绰��ù˿�����
        public String getCustNameByPhoneNum(String phoneNum){
			java.sql.Connection conn = null;
			String sql;
			String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
			        + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection(url);
			    java.sql.PreparedStatement ps = null;
			    sql = "select CUST_NAME from customer where PHONE_NUM = ?";
			    try{
			        ps = (PreparedStatement) conn.prepareStatement(sql);
			        ps.setString(1, phoneNum);
			        ResultSet rs = ps.executeQuery();
			        if(rs.next()){
			            return rs.getString(1);
			        }
			        ps.close();
			        conn.close();
			        }catch(SQLException e){
			            e.printStackTrace();
			        }    
			    } catch (SQLException e) {
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
			    return null;
        }
      //ͨ����ϵ�绰��ù˿�Ѻ��
        public double getDepositByPhoneNm(String phoneNum){
			java.sql.Connection conn = null;
			String sql;
			String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
			        + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
			try {
			    Class.forName("com.mysql.jdbc.Driver");
			    conn = DriverManager.getConnection(url);
			    java.sql.PreparedStatement ps = null;
			    sql = "select DEPOSIT from customer where PHONE_NUM = ?";
			    try{
			        ps = (PreparedStatement) conn.prepareStatement(sql);
			        ps.setString(1, phoneNum);
			        ResultSet rs = ps.executeQuery();
			        if(rs.next()){
			            return rs.getDouble(1);
			        }
			        ps.close();
			        conn.close();
			        }catch(SQLException e){
			            e.printStackTrace();
			        }    
			    } catch (SQLException e) {
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
			return 0;
			  
        }
        //ͨ���Ĵ���Ž��˱�żĴ����Ϣ���
        public void CleanBox(int num){
    		java.sql.Connection conn = null;
            String sql;
            String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                    + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = null;
                sql = "update box set PHONE_NUM = null,STATE = 0,START_TIME = null where BOX_NUM = '" + num + "'";
                try{
                	ps = (PreparedStatement) conn.prepareStatement(sql);
                	ps.executeUpdate();
                	ps.close();
                	conn.close();
                }catch(SQLException e){
                	e.printStackTrace();
                }
                
            } catch (SQLException e) {
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
        //��Ĵ������ӹ˿�
        public void AddCustToBox(int num,Customer cust){
    		java.sql.Connection conn = null;
            String sql;
            String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                    + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = null;
                Date date = new Date(System.currentTimeMillis());
                sql = "update box set PHONE_NUM = '"+ cust.getPhoneNum() +"',STATE = 1,START_TIME = '"+ date +"' where BOX_NUM = '" + num + "'";
                try{
                	ps = (PreparedStatement) conn.prepareStatement(sql);
                	ps.executeUpdate();
                	ps.close();
                	conn.close();
                }catch(SQLException e){
                	e.printStackTrace();
                }
                
            } catch (SQLException e) {
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
      //ͨ���Ĵ���Ż���ͺ�
        public String getTypeByBoxNum(int num){
			java.sql.Connection conn = null;
	        String sql;
	        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
	                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            java.sql.PreparedStatement ps = null;
	            sql = "select TYPE from box where BOX_NUM = ?";
	            try{
	            	ps = (PreparedStatement) conn.prepareStatement(sql);
	            	ps.setInt(1, num);
	            	ResultSet rs = ps.executeQuery();
	            	if(rs.next()){
	            		return rs.getString(1);
	            	}
	            	ps.close();
	            	conn.close();
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
	            
	        } catch (SQLException e) {
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
			return null;
		}
      //ͨ���Ĵ���Ż����������
        public Date getStartTimeByBoxNum(int num){
			java.sql.Connection conn = null;
	        String sql;
	        String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
	                + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url);
	            java.sql.PreparedStatement ps = null;
	            sql = "select START_TIME from box where BOX_NUM = ?";
	            try{
	            	ps = (PreparedStatement) conn.prepareStatement(sql);
	            	ps.setInt(1, num);
	            	ResultSet rs = ps.executeQuery();
	            	if(rs.next()){
	            		return rs.getDate(1);
	            	}
	            	ps.close();
	            	conn.close();
	            }catch(SQLException e){
	            	e.printStackTrace();
	            }
	            
	        } catch (SQLException e) {
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
			return null;
		}
        //���ӼĴ������
        public void addBoxType(Type type){
    		java.sql.Connection conn = null;
            String sql;
            String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                    + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = null;
                sql = "insert into type(TYPE,PRICE) values(?,?)";
                try{
                	ps = conn.prepareStatement(sql);
                	ps.setString(1,type.getType());
                	ps.setDouble(2,type.getPrice());
                	ps.executeUpdate();
                	ps.close();
                }catch (SQLException e) {
                	e.printStackTrace();
                } finally {
                	conn.close();
                }
            } catch (SQLException e) {
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
        //�������мĴ����
        public Vector<Box> getAllBox(){
    		Vector<Box> vt = new Vector<Box>();
    		java.sql.Connection conn = null;
            String sql;
            String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                    + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = null;
                sql = "select * from box";
                try{
                	ps = (PreparedStatement) conn.prepareStatement(sql);
                	ResultSet rs = ps.executeQuery();
                	while(rs.next()){
                		vt.add(new Box(rs.getInt(1),rs.getString(2)));
                	}
                	ps.close();
                	conn.close();
                	return vt;
                }catch(SQLException e){
                	e.printStackTrace();
                }
                
            } catch (SQLException e) {
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
    		return null;
    	}
        //ɾ������
        /*public void deleteType(Type type){
    		java.sql.Connection conn = null;
            String sql;
            String url = "jdbc:mysql://localhost:3306/StorageOfGoods?"
                    + "user=root&password=19941201&useUnicode=true&characterEncoding=UTF8";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                java.sql.PreparedStatement ps = null;
                sql = "delete from BOX where BOX_NUM = '" + box.getBoxNum() + "'";
                try{
                	ps = (PreparedStatement) conn.prepareStatement(sql);
                	ps.executeUpdate();
                	ps.close();
                	conn.close();
                }catch(SQLException e){
                	e.printStackTrace();
                }
                
            } catch (SQLException e) {
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
    	}*/
        
}
