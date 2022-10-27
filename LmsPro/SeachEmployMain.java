package com.infinite.LmsPro;

import java.sql.SQLException;
import java.util.Scanner;

public class SeachEmployMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int emp_Id;
		System.out.println("Enter Emp_id  ");
		emp_Id = sc.nextInt();
		EmployDAO dao = new EmployDAO();
		
		try {
			Employ employ = dao.searchEmploy(emp_Id);
			if(employ != null) {
				System.out.println(employ);
			}
			else {
				System.out.println("*** NO RECORD FOUND *** ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}