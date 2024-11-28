package school.calander;

import java.util.Scanner;

public class Date {
	
	private int numberOfDay;
	private Month numberOfMonth;
	private int year;
	
	
	public int getNumberOfDay() {
		return numberOfDay;
	}
	
	public Month getNumberOfMonth() {
		return numberOfMonth;
	}
	
	public int getYear() {
		return year;
	}
	
	
	public void setYear(int year){
		
		if (year >= 2000) {
			this.year = year;
		}
	}
	
	public void setMonth(int month){
		
		
		if (month == 2) {
			if ( year % 4 ==0 && (year % 100 != 0 || year % 400 == 0)) {
			
				this.numberOfMonth = Month.FEB_LEAP;
			}
			else {
				this.numberOfMonth = Month.FEB;
				
			}
		}
		else {
			this.numberOfMonth = Month.values()[month - 1];
			
		}
	}
	
	public void setNumberOfDays(int day) {
		if (day >= 1 && day <= numberOfMonth.getNumberOfDays()) {
			numberOfDay = day;
		}
	}
	
	
	public Date() {
		setYear(2000);
		setMonth(1);
		setNumberOfDays(1);
	}
	
	public Date(int numberOfDay,int numberOfMonth, int year) {
		setYear(year);
		setMonth(numberOfMonth);
		setNumberOfDays(numberOfDay);
	}
	
	public Date(Date d) {
		this(d.numberOfDay, d.numberOfMonth.getNumber(), d.year); 
	}
	
	public Date(String date) {
		if(date.matches("\\d{4}-\\d{2}-\\d{2}")) {
			String[] dateNumbers=date.split("-");
			setYear(Integer.parseInt(dateNumbers[0]));
			setMonth(Integer.parseInt(dateNumbers[1]));
			setNumberOfDays(Integer.parseInt(dateNumbers[2]));
		}
	}

	public static int toDays(Date date) {
		int days=0;
		for(int i=2000;i<date.year;i++) {
			if (i % 4 ==0 && (i % 100 != 0 || i % 400 == 0)) days++;
			days+=365;
		}
		
		for(int i=1;i<date.numberOfMonth.getNumber();i++) {
			if(i==2 &&(date.year % 4 ==0 && (date.year % 100 != 0 || date.year % 400 == 0))) {
				days+=Month.FEB_LEAP.getNumberOfDays();
			}
			else days+=Month.values()[i-1].getNumberOfDays();
		}
		days+=date.numberOfDay;
		return days;
	}
	public int diff(Date date) {
		return toDays(this)- toDays(date);
	}
	
	public boolean isBefore(Date date) {
		return diff(date)<0;
	}
	
	public String toString() {
		return String.format("%02d-%02d-%d", numberOfDay,numberOfMonth.getNumber(),year);
	}
}
