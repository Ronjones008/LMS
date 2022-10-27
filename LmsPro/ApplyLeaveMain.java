package com.infinite.LmsPro;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ApplyLeaveMain {
	public static void main(String[] args) {
		LeaveDAO dao = new LeaveDAO();
		Scanner sc = new Scanner(System.in);
		Leave leave = new Leave();
		System.out.println("Enter Employ Id ");
		leave.setEmp_Id(sc.nextInt());
		System.out.println("Enter Start Date  (YYYY-MM-DD)");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt = sdf.parse(sc.next());
			java.sql.Date startDate = new java.sql.Date(dt.getTime());
			leave.setLeave_Start_Date(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter End Date  (YYYY-MM-DD)");
		try {
			Date dt2 = sdf.parse(sc.next());
			java.sql.Date endDate = new java.sql.Date(dt2.getTime());
			leave.setLeave_End_Date(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter Leave Type ");
		String type = sc.next();
		if(type.toUpperCase().equals("EL")){
			leave.setLeave_Type(LeaveType.EL);
		}
		if(type.toUpperCase().equals("ML")){
			leave.setLeave_Type(LeaveType.ML);
		}
		if(type.toUpperCase().equals("PL")){
			leave.setLeave_Type(LeaveType.PL);
		}
	  System.out.println("Enter Leave Reason ");
	  leave.setLeave_Reason(sc.next());
	  try {
		System.out.println(dao.applyleave(leave));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}