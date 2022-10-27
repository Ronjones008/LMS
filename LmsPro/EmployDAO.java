package com.infinite.LmsPro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EmployDAO {
	
	Connection connection ;
	PreparedStatement pst;
	
	
	
	// employ Show
	
	public List<Employ> showEmploy() throws ClassNotFoundException, SQLException{
		
		List<Employ> employlist = new ArrayList<Employ>();
		connection = ConnectionHelper.getConnection();
		
		String cmd = "select * from employee ";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Employ employ = null;
		while(rs.next()) {
			employ = new Employ();
			employ.setEmp_Id(rs.getInt("emp_Id"));
			employ.setEmp_Name(rs.getString("emp_Name"));
			employ.setEmp_mail(rs.getString("emp_mail"));
			employ.setEmp_Mob_No(rs.getLong("emp_Mob_No"));
			employ.setEmp_Dt_Join(rs.getDate("emp_Dt_Join"));
			employ.setEmp_Dept(rs.getString("emp_Dept"));
			employ.setEmp_Manager_Id(rs.getInt("emp_Manager_Id"));
			employ.setEmp_Avail_leave_Bal(rs.getInt("emp_Avail_leave_Bal"));
			employlist.add(employ);
			
		}
		return employlist;
	}
	
	//Employ search
	
	public Employ searchEmploy(int emp_Id) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from employee where emp_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, emp_Id);
		ResultSet rs= pst.executeQuery();
		Employ employ = null ;
		if(rs.next()) {
			employ = new Employ();
			employ.setEmp_Id(rs.getInt("emp_Id"));
			employ.setEmp_Name(rs.getString("emp_Name"));
			employ.setEmp_mail(rs.getString("emp_mail"));
			employ.setEmp_Mob_No(rs.getLong("emp_Mob_No"));
			employ.setEmp_Dt_Join(rs.getDate("emp_Dt_Join"));
			employ.setEmp_Dept(rs.getString("emp_Dept"));
			employ.setEmp_Manager_Id(rs.getInt("emp_Manager_Id"));
			employ.setEmp_Avail_leave_Bal(rs.getInt("emp_Avail_leave_Bal"));
		}
	
		return employ;
		
	}
}