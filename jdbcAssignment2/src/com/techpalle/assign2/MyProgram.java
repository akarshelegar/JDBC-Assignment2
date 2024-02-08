package com.techpalle.assign2;
import java.sql.*;

public class MyProgram {

	public static void main(String[] args) {
		//A.inserting("training", "Bommnahalli", 10);
		//A.inserting("deveploment", "btm", 9);
		//A.inserting("staffing", "JP nagar", 5);
		
		//A.f1();
		
		A.f2(3);
		
		A.f3(3, "scanning");
		
		A.f2(3);
	}
}
class A
{
	private static Connection cn = null;
	private static Statement s = null;
	private static PreparedStatement ps= null;
	private static ResultSet rs = null;
	
	private static final String dbUrl = "jdbc:mysql://localhost:3306/palle";
	private static final String dbUsername = "root";
	private static final String dbPassword = "7259";
	
	public static Connection myconnection() throws ClassNotFoundException, SQLException 
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		return cn;
	}
	
	public static void  inserting(String dname, String dlocation, int dstrength)
	{
				
		try {
			cn = A.myconnection();

			ps = cn.prepareStatement("insert into dept(dname, dlocation, dstrength) values(?,?,?)");
			ps.setString(1, dname);
			ps.setString(2, dlocation);
			ps.setInt(3, dstrength);
			ps.executeUpdate();	
		}catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}	
	}
	public static void f1()
	{
		try {
			cn = myconnection();
			
			s = cn.createStatement();
			rs = s.executeQuery("select * from dept");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println("-------------");
			}	
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
			}catch(SQLException e)
				{
				e.printStackTrace();
				}			
			}		
			}
		}
	
	public static void f2(int dno)
	{
		try {
			cn = myconnection();
			
			ps = cn.prepareStatement("select * from dept where dno = ?");
			ps.setInt(1, dno);
			rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
			}catch(SQLException e)
				{
				e.printStackTrace();
				}	
			}		
		}
}
	public static void f3(int dno, String dname)
	{
		try {
			cn = myconnection();
			
			ps = cn.prepareStatement("update dept set dname = ? where dno = ?");
			ps.setString(1, dname);
			ps.setInt(2, dno);
			ps.executeUpdate();
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
			}catch(SQLException e)
				{
				e.printStackTrace();
				}	
			}		
	}
	}
}

		