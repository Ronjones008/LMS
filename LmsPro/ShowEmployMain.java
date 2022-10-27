package com.infinite.LmsPro;

import java.sql.SQLException;
import java.util.List;

public class ShowEmployMain {
	public static void main(String[] args) {
		
		EmployDAO dao =new EmployDAO();
		try {
			List<Employ> employlist = dao.showEmploy();
			for (Employ employ : employlist) {
				System.out.println(employ);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}