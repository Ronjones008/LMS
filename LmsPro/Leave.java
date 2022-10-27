package com.infinite.LmsPro;

import java.util.Date;

public class Leave {
	
	private int leave_No_Of_Days;
	private String leave_Mngr_Comments;
	private int emp_Id;
	private Date leave_Start_Date;
	private Date leave_End_Date ;
	private LeaveType  leave_Type;
	private LeaveStatus leave_Status;
	private String leave_Reason;
	 
	public Leave() {
		// TODO Auto-generated constructor stub
	}

	public Leave(int leave_No_Of_Days, String leave_Mngr_Comments, int emp_Id, Date leave_Start_Date,
			Date leave_End_Date, LeaveType leave_Type, LeaveStatus leave_Status, String leave_Reason) {
		this.leave_No_Of_Days = leave_No_Of_Days;
		this.leave_Mngr_Comments = leave_Mngr_Comments;
		this.emp_Id = emp_Id;
		this.leave_Start_Date = leave_Start_Date;
		this.leave_End_Date = leave_End_Date;
		this.leave_Type = leave_Type;
		this.leave_Status = leave_Status;
		this.leave_Reason = leave_Reason;
	}

	public int getLeave_No_Of_Days() {
		return leave_No_Of_Days;
	}

	public void setLeave_No_Of_Days(int leave_No_Of_Days) {
		this.leave_No_Of_Days = leave_No_Of_Days;
	}

	public String getLeave_Mngr_Comments() {
		return leave_Mngr_Comments;
	}

	public void setLeave_Mngr_Comments(String leave_Mngr_Comments) {
		this.leave_Mngr_Comments = leave_Mngr_Comments;
	}

	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public Date getLeave_Start_Date() {
		return leave_Start_Date;
	}

	public void setLeave_Start_Date(Date leave_Start_Date) {
		this.leave_Start_Date = leave_Start_Date;
	}

	public Date getLeave_End_Date() {
		return leave_End_Date;
	}

	public void setLeave_End_Date(Date leave_End_Date) {
		this.leave_End_Date = leave_End_Date;
	}

	public LeaveType getLeave_Type() {
		return leave_Type;
	}

	public void setLeave_Type(LeaveType leave_Type) {
		this.leave_Type = leave_Type;
	}

	public LeaveStatus getLeave_Status() {
		return leave_Status;
	}

	public void setLeave_Status(LeaveStatus leave_Status) {
		this.leave_Status = leave_Status;
	}

	public String getLeave_Reason() {
		return leave_Reason;
	}

	public void setLeave_Reason(String leave_Reason) {
		this.leave_Reason = leave_Reason;
	}

	@Override
	public String toString() {
		return "Leave [leave_No_Of_Days=" + leave_No_Of_Days + ", leave_Mngr_Comments=" + leave_Mngr_Comments
				+ ", emp_Id=" + emp_Id + ", leave_Start_Date=" + leave_Start_Date + ", leave_End_Date=" + leave_End_Date
				+ ", leave_Type=" + leave_Type + ", leave_Status=" + leave_Status + ", leave_Reason=" + leave_Reason
				+ "]";
	}
	

}