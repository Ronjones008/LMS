package com.infinite.LmsPro;

import java.sql.Date;

public class Employ {
	
	private int emp_Id;
	private String emp_Name;
	private String emp_mail;
	private long emp_Mob_No;
	private Date emp_Dt_Join;
	private String emp_Dept;
	private int emp_Manager_Id;
	private int emp_Avail_leave_Bal;
	
	public Employ() {
		// TODO Auto-generated constructor stub
	}

	public Employ(int emp_Id, String emp_Name, String emp_mail, long emp_Mob_No, Date string, String emp_Dept,
			int emp_Manager_Id, int emp_Avail_leave_Bal) {
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_mail = emp_mail;
		this.emp_Mob_No = emp_Mob_No;
		this.emp_Dt_Join = string;
		this.emp_Dept = emp_Dept;
		this.emp_Manager_Id = emp_Manager_Id;
		this.emp_Avail_leave_Bal = emp_Avail_leave_Bal;
	}

	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getEmp_mail() {
		return emp_mail;
	}

	public void setEmp_mail(String emp_mail) {
		this.emp_mail = emp_mail;
	}

	public long getEmp_Mob_No() {
		return emp_Mob_No;
	}

	public void setEmp_Mob_No(long emp_Mob_No) {
		this.emp_Mob_No = emp_Mob_No;
	}

	public Date getEmp_Dt_Join() {
		return emp_Dt_Join;
	}

	public void setEmp_Dt_Join(Date emp_Dt_Join) {
		this.emp_Dt_Join = emp_Dt_Join;
	}

	public String getEmp_Dept() {
		return emp_Dept;
	}

	public void setEmp_Dept(String emp_Dept) {
		this.emp_Dept = emp_Dept;
	}

	public int getEmp_Manager_Id() {
		return emp_Manager_Id;
	}

	public void setEmp_Manager_Id(int emp_Manager_Id) {
		this.emp_Manager_Id = emp_Manager_Id;
	}

	public int getEmp_Avail_leave_Bal() {
		return emp_Avail_leave_Bal;
	}

	public void setEmp_Avail_leave_Bal(int emp_Avail_leave_Bal) {
		this.emp_Avail_leave_Bal = emp_Avail_leave_Bal;
	}

	@Override
	public String toString() {
		return "Employ [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", emp_mail=" + emp_mail + ", emp_Mob_No="
				+ emp_Mob_No + ", emp_Dt_Join=" + emp_Dt_Join + ", emp_Dept=" + emp_Dept + ", emp_Manager_Id="
				+ emp_Manager_Id + ", emp_Avail_leave_Bal=" + emp_Avail_leave_Bal + "]";
	}
	
	
}