package com.infinite.LmsPro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveDAO {
	

	Connection connection ;
	PreparedStatement pst;
	
	
	public String approveOrdeny(int leaveId, int mgrId , String managerComments, String status) throws ClassNotFoundException, SQLException{
		
		Leave leave =  searchbyleaveId(leaveId);
	
		connection =ConnectionHelper.getConnection();
		Employ emp = new EmployDAO().searchEmploy(leave.getEmp_Id());
		int empid = emp.getEmp_Id();
		
		int mgId = emp.getEmp_Manager_Id();
		
		int noOfDays = leave.getLeave_No_Of_Days();
		if(mgrId == mgId){
			if(status.toUpperCase().equals("YES")){
			String cmd = "update leave_history set leave_status ='APPROVED',leave_mngr_comments = ? where leave_Id= ?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, managerComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			return "Your Leave was Applied ";
		}else{
			String cmd ="update leave_history set leave_status ='DENIED',  leave_mngr_comments = ? where leave_Id =? ";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, managerComments);
			pst.setInt(2, leaveId);
			pst.executeUpdate();
			cmd =" update employee set emp_avail_Leave_bal = emp_avail_leave_bal+? where emp_id=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, noOfDays);
			pst.setInt(2, empid);
			pst.executeUpdate();
			return "your leave not applied";
		}
	}
		else{
			return "your are leave approved";
		}
	}
	public String applyleave(Leave leave) throws ClassNotFoundException, SQLException {
		
		Employ employ = new Employ();
		long diff = leave.getLeave_End_Date().getTime() - leave.getLeave_Start_Date().getTime();
		long m = diff /(1000*24*60*60);
		int days = (int)m;
		days = days+1;
		leave.setLeave_Type(LeaveType.EL);
		leave.setLeave_Status(LeaveStatus.PENDING);
		EmployDAO edao = new EmployDAO();
		Employ empoly = edao.searchEmploy(leave.getEmp_Id());
		if(empoly != null){
			int avil = empoly.getEmp_Avail_leave_Bal();
			System.out.println("Days  "+days);
			System.out.println("leave bal "+avil);
			if(days<0){
				return "Leave Start Date cannot be greater than leaveEnd Date";
			}
			else if(avil-days <0){
			   return "Insufficient Leave Balance ";
		   }else{
			   int d = avil -days;
			   leave.setLeave_No_Of_Days(days);
		connection = ConnectionHelper.getConnection();
		String cmd = " insert into leave_history (Emp_Id,leave_Start_Date,leave_End_Date,leave_Type,leave_Status,leave_Reason,leave_No_Of_Days)"
				     +"values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leave.getEmp_Id());
		pst.setDate(2, (Date) leave.getLeave_Start_Date());
		pst.setDate(3, (Date) leave.getLeave_End_Date());
		pst.setString(4, leave.getLeave_Type().toString());
		pst.setString(5, leave.getLeave_Status().toString());
		pst.setString(6, leave.getLeave_Reason());
		pst.setInt(7, leave.getLeave_No_Of_Days());
		pst.executeUpdate();
		cmd = "update employee set emp_Avail_Leave_Bal = emp_Avail_Leave_Bal -? where emp_Id = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, days);
		pst.setInt(2, leave.getEmp_Id());
		pst.executeUpdate();
		return "Leave Applied";
		   }
		}
		else{
			return "Invalid Employ Id ";
		}
}
	public Leave searchbyleaveId(int leaveId) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from leave_history where leave_Id =?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveId);
		ResultSet rs = pst.executeQuery();
		Leave leave = null;
		if(rs.next()){
			leave = new Leave();
			leave.setEmp_Id(rs.getInt("EMP_ID"));
			leave.setLeave_Start_Date( rs.getDate("leave_Start_Date"));
			leave.setLeave_End_Date( rs.getDate("leave_End_Date"));
			leave.setLeave_Mngr_Comments(rs.getString("leave_Mngr_Comments"));
			leave.setLeave_No_Of_Days(rs.getInt("leave_No_Of_Days"));
			leave.setLeave_Reason(rs.getString("leave_Reason"));	
		}
		return leave;
	}
	
}
