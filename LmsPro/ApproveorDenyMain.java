package com.infinite.LmsPro;

import java.sql.SQLException;
import java.util.Scanner;

public class ApproveorDenyMain {
	public static void main(String[] args) {
		
  int leaveId,mgrId;
  String managerComments,status;
  Scanner sc  = new Scanner(System.in);
  System.out.println("Enter Leave Id ");
  leaveId  = sc.nextInt();
  System.out.println("Enter Manger Id ");
  mgrId = sc.nextInt();
  System.out.println("Enter Manger Comments ");
  managerComments = sc.next();
  System.out.println("Status (yes/no) ");
  status = sc.next().toUpperCase();
  LeaveDAO dao = new LeaveDAO();
  try {
	System.out.println(dao.approveOrdeny(leaveId, mgrId, managerComments, status));
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
