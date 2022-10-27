package com.infinite.LmsPro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2022-12-12";
		try {
			Date dt = sdf.parse(str);
			System.out.println(dt);
			System.out.println(sdf.format(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
